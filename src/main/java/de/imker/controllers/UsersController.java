package de.imker.controllers;

import de.imker.controllers.api.UsersApi;
import de.imker.dto.EventDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateEventDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.imker.services.UsersService;

@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

  private final UsersService usersService;

  @Override
  public ResponseEntity<UserDto> addUser(@RequestBody NewUserDto newUser) {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.addUser(newUser));
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
        .ok(usersService.updateUser(userId,updateUser));
  }

  @Override
  public ResponseEntity<UserDto> getUser(Long userId) {
    return ResponseEntity
        .ok(usersService.getUser(userId));
  }
}
