package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

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
import de.imker.services.UsersService;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

  UsersRepository usersRepository;
  PasswordEncoder passwordEncoder;



  private UserDto findByEmail(String email) {
    UsersDto list = getAllUsers();
    return list.getUsers()
        .stream()
        .filter(p -> p.getEmail().equals(email))
        .findFirst()
        .orElse(null);
  }

  @Override
  public UserSecretQuestionsDto getSecretQuestions(UserEmailDto userEmail) {
    UserDto userDto = findByEmail(userEmail.getEmail());                      //can refactor this
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

    if (user.getSecretQuestion().equals(secretQuestionAnswer.getSecretQuestion())) {
      if (user.getAnswerSecretQuestion().equals(secretQuestionAnswer.getSecretQuestionAnswer())) {
        return UserIdDto.builder()
            .id(user.getId())
            .build();
      }
    }
    return null; //may be throw error?
  }

  @Override
  public UserDto setNewPassword(UserRestorePwdDto restorePwd) {

    User user = getUserFromRepository(restorePwd.getId());
    user.setHashPassword(passwordEncoder.encode(restorePwd.getNewPassword()));
    usersRepository.save(user);
    return UserDto.from(user);
  }

  @Override
  public UsersDto getAllUsers() {

    return UsersDto.builder()
        .users(from(usersRepository.findAll()))
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
        () -> new NotFoundException("User with id <" + userId + "> not found"));
  }

  private User getUserOrThrow(Long userId) {
    return usersRepository.findById(userId).orElseThrow(
        () -> new RestException(HttpStatus.NOT_FOUND, "User with Id <" + userId + "> not found"));
  }
}


