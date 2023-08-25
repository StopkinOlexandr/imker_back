package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

import de.imker.dto.RegisterDto;
import de.imker.dto.UserDto;
import de.imker.models.User;
import de.imker.models.User.Role;
import de.imker.models.User.State;
import de.imker.repositories.UsersRepository;
import de.imker.services.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class RegisrationServiceImpl implements RegistrationService {
  UsersRepository usersRepository;

  PasswordEncoder passwordEncoder;

  @Transactional
  @Override
  public UserDto register(RegisterDto registerData) {
    User user = User.builder()
        .email(registerData.getEmail())
        .hashPassword(passwordEncoder.encode(registerData.getPassword()))
        .name(registerData.getName())
        .plz(registerData.getPlz())
        .phone(registerData.getPhone())
        .role(Role.USER)
        .state(State.CONFIRMED).build();

    usersRepository.save(user);

    return from(user);
  }
}
