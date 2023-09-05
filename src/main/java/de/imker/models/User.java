package de.imker.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"secretQuestion", "password", "plz", "phone", "image", "role", "state"})
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

  @ManyToMany
  @JoinTable(
      name = "user_event",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "events_id", referencedColumnName = "id")
  )
  private List<Event> events;

}
