package de.imker.InitializationData;

import de.imker.models.User;
import de.imker.models.User.Role;
import de.imker.models.User.State;
import de.imker.repositories.UsersRepository;
import de.imker.services.FilesService;
import de.imker.services.impl.UsersServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitialization {
  private final UsersRepository usersRepository;

  PasswordEncoder passwordEncoder;

  @Autowired
  public UserInitialization(UsersRepository usersRepository, FilesService filesService) {
    UsersServiceImpl usersService = new UsersServiceImpl(usersRepository, passwordEncoder, filesService);
    this.usersRepository = usersRepository;
  }

  public void userInit() {
    List<User> users = usersRepository.findAll();
    if (users.size() == 0) {
      User user = User.builder()
          .email("boss@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Boss")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.ADMIN)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);

      user = User.builder()
          .email("user@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Alex Krause")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.USER)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);

      user = User.builder()
          .email("member@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Alexander Friedrich Schmidt")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.MEMBER)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);

      user = User.builder()
          .email("member2@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Friedrich Schmidt")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.MEMBER)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);

      user = User.builder()
          .email("member3@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Anna Müller")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.MEMBER)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);

      user = User.builder()
          .email("member4@gmail.com")
          .hashPassword("$2a$10$INw4/IiTNe9XwikhBxmezeUNsS7MXJPWTs1rGb6lEwfPENWnBBasu") //!Boss12345
          .name("Annabel Schmidt")
          .plz("01234")
          .image("")
          .phone("01234567890123")
          .secretQuestion("Auto?")
          .answerSecretQuestion("Ford")
          .role(Role.MEMBER)
          .state(State.CONFIRMED).build();
      usersRepository.save(user);
    }
  }
}
