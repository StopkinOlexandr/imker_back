package de.imker.services.impl;

import static de.imker.dto.UserDto.from;

import de.imker.dto.RegisterDto;
import de.imker.dto.UserDto;
import de.imker.models.User;
import de.imker.models.User.Role;
import de.imker.models.User.State;
import de.imker.repositories.UsersRepository;
import de.imker.services.RegistrationService;
import de.imker.services.telegrammNotice.TelegramNotice;
import java.util.Optional;
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
    if (usersRepository.findByEmail(registerData.getEmail()).isPresent()) return null;
    User user = User.builder()
        .email(registerData.getEmail())
        .hashPassword(passwordEncoder.encode(registerData.getPassword()))
        .name(registerData.getName())
        .plz(registerData.getPlz())
        .image("")
        .phone(registerData.getPhone())
        .secretQuestion(registerData.getSecretQuestion())
        .answerSecretQuestion(registerData.getAnswerSecretQuestion())
        .role(Role.USER)
        .state(State.CONFIRMED).build();

    usersRepository.save(user);
    String message = String.format("""
        New user registered:

          Email: %s
          Name: %s
          PLZ: %s
          PhoneNumber: %s
          Role: %s
        """,user.getEmail(),
        user.getName(),
        user.getPlz(),
        user.getPhone(),
        user.getRole());
    TelegramNotice.sendTelegramNotice(message);
    return from(user);
  }
}
