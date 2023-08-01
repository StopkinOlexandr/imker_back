package de.imker.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  public enum Role {
    ADMIN,
    USER
  }

  public enum State {
    NOT_CONFIRMED,
    CONFIRMED,
    BANNED,
    DELETED
  }

  private Long id;

  private String email;
  private String name;
  private String password;
  private String plz;
  private String phone;
  private String image;
  private String secretQuestion;
  private Role role;
  private State state;
  private Boolean isLogin;

//  private String token;
//  private String coordinates;
}
