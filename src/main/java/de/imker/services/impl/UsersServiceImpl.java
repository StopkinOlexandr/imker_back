package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

import de.imker.dto.NewUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import de.imker.services.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

  private final UsersRepository usersRepository;

  @Override
  public UserDto addUser(NewUserDto newUser) {
    User user = User.builder()
        .email(newUser.getEmail())
        .password(newUser.getPassword())
        .role(User.Role.USER)
        .state(User.State.NOT_CONFIRMED).build();

    usersRepository.save(user);

    return from(user);
  }

  @Override
  public UsersDto getAllUsers() {

    List<User> users = usersRepository.findAll();
    return UsersDto.builder()
        .users(from(users))
        .count(users.size())
        .build();
  }
}
