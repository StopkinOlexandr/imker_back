package de.imker.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(of = {"id", "title"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "events")
//@EqualsAndHashCode(exclude = "events")
//@ToString(exclude = "events")
public class Event {

  public enum Status {
    EXPECTED,
    ENDED,
    ARCHIVE
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String address;
  private String author;
  private String description;
  private String shortDescription;
  private Integer quantityOfMembers;
  private String photo;
  private String dateStart;
  private String dateEnd;
  private String startTime;
  private String endTime;
  private String location;
  @Enumerated(value = EnumType.STRING)
  private Status status;

  @ManyToMany(mappedBy = "events")
  private List<User> users;
}
