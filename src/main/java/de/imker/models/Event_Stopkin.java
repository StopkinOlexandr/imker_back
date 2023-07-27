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
public class Event_Stopkin {

  public enum State {
    PLANNED,
    CONFIRMED,
    CANCELED,
    FINISHED
  }

  private Long id;
  private String name;
  private String address;
  private String description;
  private String image;
  private List<User> registeredOnEventUsers;

  private Event_Stopkin.State state;


}
