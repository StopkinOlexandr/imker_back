package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import de.imker.exeptions.ForbiddenFieldException;
import de.imker.exeptions.ForbiddenOperationException;
import de.imker.exeptions.NotFoundException;
import de.imker.exeptions.UserNotFoundException;
import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import de.imker.services.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

  private final UsersRepository usersRepository;

  @Value("${users.sort.fields}")
  private List<String> sortFields;

  @Value("${users.filter.fields}")
  private List<String> filterFields;

  @Value("${users.page.size}")
  private Integer pageSize;

  @Override
  public UserDto addUser(NewUserDto newUser) {
    User user = User.builder()
        .email(newUser.getEmail())
        .password(newUser.getPassword())
        .name(newUser.getName())
        .plz(newUser.getPlz())
        .phone(newUser.getPhone())
        .secretQuestion(newUser.getSecretQuestion())
        .role(User.Role.USER)
        .state(User.State.NOT_CONFIRMED).build();

    usersRepository.save(user);

    return from(user);
  }

  @Override
  public UsersDto getAllUsers(Integer pageNumber,
      String orderByField,
      Boolean desc,
      String filterBy,
      String filterValue) {

    PageRequest pageRequest = getPageRequest(pageNumber, orderByField, desc);

    Page<User> page = getUsersPage(filterBy, filterValue, pageRequest);

    return UsersDto.builder()
        .users(from(page.getContent()))
        .count(page.getTotalElements())
        .pagesCount(page.getTotalPages())
        .build();
  }

  private Page<User> getUsersPage(String filterBy, String filterValue, PageRequest pageRequest) {
    Page<User> page = Page.empty();
    if (filterBy == null || filterBy.equals("")) {
      page = usersRepository.findAll(pageRequest);
    } else {
      checkField(filterFields, filterBy);
      if (filterBy.equals("role")) {
        User.Role role = User.Role.valueOf(filterValue);
        page = usersRepository.findAllByRole(role, pageRequest);
      } else if (filterBy.equals("state")) {
        User.State state = User.State.valueOf(filterValue);
        page = usersRepository.findAllByState(state, pageRequest);
      }
    }
    return page;
  }

  @Override
  public UserDto deleteUser(Long userId) {

    User user = getUserFromRepository(userId);

    usersRepository.delete(user);
    return UserDto.from(user);
  }

  @Override
  public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
    User user = getUserFromRepository(userId);
    user.setName(updateUser.getNewName());
    user.setPlz(updateUser.getNewPlz());
    user.setPhone(updateUser.getNewPhone());
    user.setImage(updateUser.getNewImage());
    user.setState(User.State.valueOf(updateUser.getNewState()));
    user.setRole(User.Role.valueOf(updateUser.getNewRole()));

    usersRepository.save(user);
    return UserDto.from(user);
  }

  @Override
  public UserDto getUser(Long userId) {
    return from(getUserOrThrow(userId));
  }

  private User getUserFromRepository(Long userId) {
    return usersRepository.findById(userId).orElseThrow(
        () -> new NotFoundException("Event with id <" + userId + "> not found"));
  }

  private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc) {

    if (orderByField != null && !orderByField.equals("")) {

      checkField(sortFields, orderByField);

      Sort.Direction direction = Sort.Direction.ASC;

      if (desc != null && desc) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderByField);

      return PageRequest.of(pageNumber, pageSize, sort);
    } else {
      return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
    }
  }

  private void checkField(List<String> allowedFields, String field) {
    if (!allowedFields.contains(field)) {
      throw new ForbiddenFieldException(field);
    }
  }

  private User getUserOrThrow(Long userId) {
    return usersRepository.findById(userId).orElseThrow(
        () -> new UserNotFoundException("User",
            userId)); //TODO change for all entities (not only user)
  }
}


