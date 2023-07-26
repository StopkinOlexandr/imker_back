package de.imker.services;

import de.imker.dto.NewUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;

public interface UsersService {
  UserDto addUser(NewUserDto newUser);

  UsersDto getAllUsers();
}
