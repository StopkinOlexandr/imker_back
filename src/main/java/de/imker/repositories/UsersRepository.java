package de.imker.repositories;


import de.imker.models.User;
import java.util.List;
import java.util.Optional;

public interface UsersRepository {
  void saveUser(User user);

  List<User> findAllUsers();

  Optional<User> findById(Long id);

  void delete(User user);
  void clearUsers();
}
