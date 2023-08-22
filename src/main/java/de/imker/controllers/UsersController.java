package de.imker.controllers;

import de.imker.controllers.api.UsersApi;
import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionDto;
import de.imker.dto.UserSigninDto;
import de.imker.dto.UsersDto;
import de.imker.security.details.AuthenticatedUser;
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
  public ResponseEntity<UserIdDto> secretQuestion(UserSecretQuestionDto secretQuestion) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.checkSecretQuestion(secretQuestion));
  }

  @Override
  public ResponseEntity<UserDto> newPassword(UserRestorePwdDto restorePwd) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.setNewPassword(restorePwd));
  }

  @Override
  public ResponseEntity<UserDto> addUser(@RequestBody NewUserDto newUser) {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.addUser(newUser));
  }

  @Override
  public ResponseEntity<UserDto> loginUser(@RequestBody UserSigninDto loginUser) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.loginUser(loginUser));
//    return null;
  }

  @Override
  public ResponseEntity<UsersDto> getAllUsers(Integer pageNumber,
      String orderBy,
      Boolean desc,
      String filterBy,
      String filterValue) {
    return ResponseEntity
        .ok(usersService.getAllUsers(pageNumber, orderBy, desc, filterBy, filterValue));
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
  public ResponseEntity<UserDto> getUser(Long userId) {
    return ResponseEntity
        .ok(usersService.getUser(userId));
  }
}
