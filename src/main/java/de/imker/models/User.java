package de.imker.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"secretQuestion", "password", "plz", "phone", "image", "role", "state", "isLogin"})
@Entity
@Table(name = "account")
public class User {

  public enum Role {
    ADMIN,
    MEMBER,
    USER
  }

  public enum State {
    NOT_CONFIRMED,
    CONFIRMED,
    BANNED,
    DELETED
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  private String name;

  @Column(nullable = false)
  private String hashPassword;
//  private String password;

  @Column(nullable = false)
  private String secretQuestion;

  private String answerSecretQuestion;

  private String plz;

  private String phone;

  private String image;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private Role role;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private State state;

  private Boolean isLogin;

//  private String token;
//  private String coordinates;
}
