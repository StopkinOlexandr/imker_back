package de.imker.services;

import de.imker.dto.RegisterDto;
import de.imker.dto.UserDto;

public interface RegistrationService
{
  UserDto register(RegisterDto registerData);
}
