package de.imker.services;

import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserEmailDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionAnswerDto;
import de.imker.dto.UserSecretQuestionsDto;
import de.imker.dto.UsersDto;

public interface UsersService {

  UsersDto getAllUsers(Integer page, Integer items, String orderBy, Boolean desc);

  UserDto deleteUser(Long userId);

  UserDto updateUser(Long userId, UpdateUserDto updateUser);

  UserDto getUser(Long userId);

  UserSecretQuestionsDto getSecretQuestions(UserEmailDto userEmail);

  UserIdDto getSecretQuestionAnswer(UserSecretQuestionAnswerDto secretQuestionAnswer);

  UserDto setNewPassword(UserRestorePwdDto restorePwd);

  UserDto updateUserAdmin(Long userId, UpdateUserDto updateUser);
}
