package de.imker.repositories;


import de.imker.models.User;
import java.util.List;

public interface UsersRepository {
  void save(User user);

  List<User> findAll();

  void clear();
}
