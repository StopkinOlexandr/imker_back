package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    public enum Status {
        EXPECTED,
        ENDED,
        ARCHIVE
    }
    private Long id;
    private String name;
    private String quantityOfMembers;
    private String place;
    private String description;
    private String author;
    private String photo;
    private Status status;
    private String date;

    private List<Event_Stopkin> events;
}
