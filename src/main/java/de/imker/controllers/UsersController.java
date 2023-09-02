package de.imker.controllers;

import de.imker.controllers.api.UsersApi;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserEmailDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionAnswerDto;
import de.imker.dto.UserSecretQuestionsDto;
import de.imker.dto.UsersDto;
import de.imker.security.details.AuthenticatedUser;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.imker.services.UsersService;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

  UsersService usersService;

  @Override
  public ResponseEntity<UserDto> getMyProfile(AuthenticatedUser currentUser) {
    Long userId = currentUser.id();
    return ResponseEntity.ok(usersService.getUser(userId));
  }

  @Override
  public ResponseEntity<UserSecretQuestionsDto> secretQuestions(UserEmailDto userEmail) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(usersService.getSecretQuestions(userEmail));
  }

  @Override
  public ResponseEntity<UserIdDto> secretQuestionAnswer(
      UserSecretQuestionAnswerDto secretQuestionAnswer) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(usersService.getSecretQuestionAnswer(secretQuestionAnswer));
  }

  @Override
  public ResponseEntity<UserDto> newPassword(UserRestorePwdDto restorePwd) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(usersService.setNewPassword(restorePwd));
  }

  @Override
  public ResponseEntity<UsersDto> getAllUsers(Integer page, Integer items, String orderBy, Boolean desc) {

    return ResponseEntity
        .ok(usersService.getAllUsers(page, items, orderBy, desc));
  }


  @Override
  public ResponseEntity<UserDto> deleteUser(Long userId) {
    return ResponseEntity
        .ok(usersService.deleteUser(userId));
  }

  @Override
  public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
    return ResponseEntity
        .ok(usersService.updateUser(userId, updateUser));
  }

  @Override
  public ResponseEntity<UserDto> updateUserAdmin(Long userId, UpdateUserDto updateUser) {
    return ResponseEntity
        .ok(usersService.updateUserAdmin(userId, updateUser));
  }

  @Override
  public ResponseEntity<UserDto> getUser(Long userId) {
    return ResponseEntity
        .ok(usersService.getUser(userId));
  }
}
