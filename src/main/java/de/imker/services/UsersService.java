package de.imker.services;

import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionDto;
import de.imker.dto.UserSigninDto;
import de.imker.dto.UsersDto;

public interface UsersService {

  UserDto addUser(NewUserDto newUser);

  UsersDto getAllUsers(Integer pageNumber, String orderByField, Boolean desc, String filterBy, String filterValue);

  UserDto deleteUser(Long userId);

  UserDto updateUser(Long userId, UpdateUserDto updateUser);

  UserDto getUser(Long userId);

  UserDto loginUser(UserSigninDto loginUser);


  UserIdDto checkSecretQuestion(UserSecretQuestionDto secretQuestion);

  UserDto setNewPassword(UserRestorePwdDto restorePwd);
}
