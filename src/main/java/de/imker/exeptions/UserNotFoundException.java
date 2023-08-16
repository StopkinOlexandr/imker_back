package de.imker.exeptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException  extends RestException{
  public UserNotFoundException(String entity, Long id) {
    super(HttpStatus.NOT_FOUND, entity + " with id <" + id + "> not found.");
  }
}
