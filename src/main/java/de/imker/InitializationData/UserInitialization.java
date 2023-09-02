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
  private final UsersServiceImpl usersService;
  private final UsersRepository usersRepository;
  private final FilesService filesService;

  PasswordEncoder passwordEncoder;

  @Autowired
  public UserInitialization(UsersRepository usersRepository, FilesService filesService) {
    this.usersService = new UsersServiceImpl(usersRepository, passwordEncoder, filesService);
    this.usersRepository = usersRepository;
    this.filesService = filesService;
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
    }
  }
}
