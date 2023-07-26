package de.imker.repositories.impl;

import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepositoryListImpl implements UsersRepository {
  private static List<User> users = new ArrayList<>();

  @Override
  public void save(User user) {
    user.setId((long) users.size() + 1); // id пользователя - его порядковый номер в списке
    users.add(user);
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(users);
  }

  @Override
  public void clear() {
    users.clear();
  }
}
