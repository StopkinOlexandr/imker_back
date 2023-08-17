package de.imker.repositories.impl;

import de.imker.models.Event;
import de.imker.models.User;
import de.imker.repositories.UsersRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
//public class UsersRepositoryListImpl implements UsersRepository {
public class UsersRepositoryListImpl  {
//  private static List<User> users = new ArrayList<>();
//
//  @Override
//  public void saveUser(User user) {
//    if (user.getId() == null) {
//      user.setId((long) users.size() + 1);
//      users.add(user);
//    }else{
//      //если это БД или файл то обновляем в хранилище
//    }
//  }
//
//  @Override
//  public List<User> findAllUsers() {
//    return new ArrayList<>(users);
//  }
//
//  @Override
//  public Optional<User> findById(Long id) {
//    for (User user : users) {
//      if (user.getId().equals(id)) {
//        return Optional.of(user);
//      }
//    }
//    return Optional.empty();
//  }
//
//  @Override
//  public void delete(User user) {
//    users.remove(user);
//  }
//
//  @Override
//  public void clearUsers() {
//    users.clear();
//  }
}
