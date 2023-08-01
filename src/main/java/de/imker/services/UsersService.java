package de.imker.services;

import de.imker.dto.EventDto;
import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateEventDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;

public interface UsersService {
  UserDto addUser(NewUserDto newUser);

  UsersDto getAllUsers();

  UserDto deleteUser(Long userId);

  UserDto updateUser(Long userId, UpdateUserDto updateUser);
}
