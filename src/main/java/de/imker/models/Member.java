package de.imker.models;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "member")
public class Member {

  public enum State {
    SHOW, HIDDEN
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Enumerated(value = EnumType.STRING)
  private State state;
  private String name;
  private String position;
  private String description;
  private String image;
  private String phone;
  private String email;
  private String facebook;
  private String instagram;
}
