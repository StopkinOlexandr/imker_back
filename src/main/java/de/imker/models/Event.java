package de.imker.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
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
    private String quantityOfMembers;
    private String photo;
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    @Enumerated(value = EnumType.STRING)
    private Status status;

//    @OneToMany(mappedBy = "user_ID")//TODO
//    private List<Event> events;


}
