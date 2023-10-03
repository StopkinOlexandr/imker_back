package de.imker.services.impl;

import static de.imker.dto.UserDto.from;
import static de.imker.utils.UtilsMethods.getPageRequest;

import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserEmailDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionAnswerDto;
import de.imker.dto.UserSecretQuestionsDto;
import de.imker.dto.UsersDto;
import de.imker.exeptions.NotFoundException;
import de.imker.exeptions.RestException;
import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import de.imker.services.FilesService;
import de.imker.services.UsersService;
import de.imker.services.telegrammNotice.TelegramNotice;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

  UsersRepository usersRepository;
  PasswordEncoder passwordEncoder;
  FilesService filesService;

  public UserDto findByEmail(String email) {
    return from(Objects.requireNonNull(usersRepository.findAll()
        .stream()
        .filter(p -> p.getEmail().equals(email))
        .findFirst()
        .orElseThrow(
            () -> new RestException(HttpStatus.NOT_FOUND,
                "User with Email <" + email + "> not found"))));
  }

  @Override
  public UserSecretQuestionsDto getSecretQuestions(UserEmailDto userEmail) {
    System.out.println("User email" + userEmail);
    UserDto userDto = findByEmail(userEmail.getEmail());
    System.out.println(userDto);
    User user = usersRepository.findById(userDto.getId()).orElseThrow(
        () -> new NotFoundException("User with id <" + userDto.getId() + "> not found"));

    List<String> list = new ArrayList<>();
    list.add(user.getSecretQuestion());
    list.add("Wie hieß Ihre erstes Tier?");
    list.add("Wie heißt Ihre erste Schule?");
    list.add("Wie hieß Ihr erster Lehrer/Lehrerin?");
    list.add("Was ist Ihre Lieblingsblume?");
    return UserSecretQuestionsDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .secretQuestions(list)
        .build();
  }

  @Override
  public UserIdDto getSecretQuestionAnswer(UserSecretQuestionAnswerDto secretQuestionAnswer) {
    UserDto userDto = findByEmail(secretQuestionAnswer.getEmail());
    User user = usersRepository.findById(userDto.getId()).orElseThrow(
        () -> new NotFoundException("User with id <" + userDto.getId() + "> not found"));

    String message = String.format("""
            User with ID %s tried to restore his password.
              Email: %s
              Name: %s
              PLZ: %s
              PhoneNumber: %s
              Role: %s
            """, user.getId().toString(),
        user.getEmail(),
        user.getName(),
        user.getPlz(),
        user.getPhone(),
        user.getRole());
    TelegramNotice.sendTelegramNotice(message);

    if (user.getSecretQuestion().equals(secretQuestionAnswer.getSecretQuestion())) {
      if (user.getAnswerSecretQuestion().equals(secretQuestionAnswer.getSecretQuestionAnswer())) {
        return UserIdDto.builder()
            .id(user.getId())
            .build();
      }
    }
    throw new RestException(HttpStatus.NOT_FOUND,"Wrong secret question / answer combination");
  }

  @Override
  public UserDto setNewPassword(UserRestorePwdDto restorePwd) {

    User user = getUserOrThrow(restorePwd.getId());
    user.setHashPassword(passwordEncoder.encode(restorePwd.getNewPassword()));
    usersRepository.save(user);
    return UserDto.from(user);
  }

  @Override
  public UserDto updateUserAdmin(Long userId, UpdateUserDto updateUser) {
    User user = getUserOrThrow(userId);
    user.setName(updateUser.getName());
    user.setPlz(updateUser.getPlz());
    user.setPhone(updateUser.getPhone());

    if (!user.getImage().equals(updateUser.getImage())){
      filesService.deleteFileById(Long.valueOf(user.getImage()));
    }
    user.setImage(updateUser.getImage());

    user.setState(User.State.valueOf(updateUser.getState()));
    user.setRole(User.Role.valueOf(updateUser.getRole()));

    usersRepository.save(user);
    return UserDto.from(user);
  }

  @Override
  public UsersDto getAllUsers(Integer page, Integer items, String orderBy, Boolean desc) {
    Page<User> pageOfUsers;

    PageRequest pageRequest = getPageRequest(page, items, orderBy, desc);

    pageOfUsers = usersRepository.findAll(pageRequest);
    return UsersDto.builder()
        .users(from(pageOfUsers.getContent()))
        .count((int) pageOfUsers.getTotalElements())
        .pages(pageOfUsers.getTotalPages())
        .build();
  }

  @Override
  public UserDto deleteUser(Long userId) {

    User user = getUserOrThrow(userId);

    usersRepository.delete(user);
    filesService.deleteFileById(Long.valueOf(user.getImage()));
    return UserDto.from(user);
  }

  @Override
  public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
    User user = getUserOrThrow(userId);

    user.setName(updateUser.getName());
    user.setPlz(updateUser.getPlz());
    user.setPhone(updateUser.getPhone());

    if (!user.getImage().equals(updateUser.getImage())){
      filesService.deleteFileById(Long.valueOf(user.getImage()));
    }
    user.setImage(updateUser.getImage());

    usersRepository.save(user);
    return UserDto.from(user);
  }

  @Override
  public UserDto getUser(Long userId) {
    return from(getUserOrThrow(userId));
  }

  private User getUserOrThrow(Long userId) {
    return usersRepository.findById(userId).orElseThrow(
        () -> new RestException(HttpStatus.NOT_FOUND, "User with Id <" + userId + "> not found"));
  }
}


