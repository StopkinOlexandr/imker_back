package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

import de.imker.dto.EventDto;
import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateEventDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import de.imker.exeptions.ForbiddenOperationException;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Event;
import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import de.imker.services.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

  private final UsersRepository usersRepository;

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

    usersRepository.saveUser(user);

    return from(user);
  }

  @Override
  public UsersDto getAllUsers() {

    List<User> users = usersRepository.findAllUsers();
    return UsersDto.builder()
        .users(from(users))
        .count(users.size())
        .build();
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

//    if (updateUser.getNewRole().equals("ADMIN")) {
//      throw new ForbiddenOperationException("Cannot make an administrator");
//    }

    user.setName(updateUser.getNewName());
    user.setPlz(updateUser.getNewPlz());
    user.setPhone(updateUser.getNewPhone());
    user.setImage(updateUser.getNewImage());
    user.setState(User.State.valueOf(updateUser.getNewState()));
    user.setRole(User.Role.valueOf(updateUser.getNewRole()));

    //TODO change place

    usersRepository.saveUser(user);
    return UserDto.from(user);
  }

  private User getUserFromRepository(Long userId) {
    return usersRepository.findById(userId).orElseThrow(
        () -> new NotFoundException("Event with id <" + userId + "> not found"));
  }
}
