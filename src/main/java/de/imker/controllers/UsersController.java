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
import org.springframework.web.bind.annotation.*;
import de.imker.services.UsersService;

@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

  private final UsersService usersService;

  @Override
  public UserDto addUser(@RequestBody NewUserDto newUser) {
    return usersService.addUser(newUser);
  }

  @Override
  public UsersDto getAllUsers() {
    return usersService.getAllUsers();
  }

  @Override
  public UserDto deleteUser(Long userId) { return usersService.deleteUser(userId);}

  @Override
  public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
    return usersService.updateUser(userId,updateUser);
  }

}
