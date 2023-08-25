package de.imker.dto;

import de.imker.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Events Value")
public class EventDto {

    @Schema(description = "Event's ID", example = "1")
    private Long idEvent;

    @Schema(description = "Events title", example = "Some event's title...")
    private String title;


    @Schema(description = "Event's address", example = "Berlin, Kirchweg str., 13")
    private String address;

    @Schema(description = "Events author", example = "Andrii")
    private String author;

    @Schema(description = "Events status - EXPECTED, ENDED, ARCHIVE ", example = "EXPECTED")
    private String status;

    @Schema(description = "Events description", example = "Wash car")
    private String description;

    @Schema(description = "Events short description", example = "Wash car")
    private String shortDescription;

    @Schema(description = "Location of event", example = "https://gpp/gl/maps/...")
    private String location;


    @Schema(description = "Planned number of participants", example = "182")
    private String quantityOfMembers;//int

    @Schema(description = "Address of photo", example = "./src/photo/photo12.png")
    private String photo;


    @Schema(description = "Publishing start date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateStart;

    @Schema(description = "Publishing End date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateEnd;

    @Schema(description = "Start time of event", example = "16:00")
    private String startTime;

    @Schema(description = "End time of event", example = "18:00")
    private String endTime;



    public static EventDto from(Event event) {
        return EventDto.builder()
                .idEvent(event.getEventId())
                .title(event.getTitle())
                .description(event.getDescription())
                .shortDescription(event.getShortDescription())
                .address(event.getAddress())
                .author(event.getAuthor())
                .location(event.getLocation())
                .photo(event.getPhoto())
                .dateStart(event.getDateStart())
                .dateEnd(event.getDateEnd())
                .startTime(event.getStartTime())
                .quantityOfMembers(event.getQuantityOfMembers())
                .endTime(event.getEndTime())
                .status(Event.Status.EXPECTED.toString())

                .build();

    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }
}
