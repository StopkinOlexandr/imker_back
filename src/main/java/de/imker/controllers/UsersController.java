package de.imker.controllers;

import de.imker.dto.NewUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import de.imker.services.UsersService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

  private final UsersService usersService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto addUser(@RequestBody NewUserDto newUser) {
    return usersService.addUser(newUser);
  }

  @GetMapping
  public UsersDto getAllUsers() {
    return usersService.getAllUsers();
  }
}
