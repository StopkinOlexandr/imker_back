package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Schema(description = "Information for adding new event")
@Data

public class NewEventDto {
//@NotNull
   // @NotBlank
    @Size(min=3,max=1200)
    @Schema(description = "Even's title", example = "Honigfest 2023")
    private String title;

    @NotNull
    @NotBlank
    @Schema(description = "Description of event", example = "Herzlich willkommen auf unserem Honigfest")
    private String description;

    @NotNull
    @NotBlank
    @Schema(description = "Short description of event", example = "Honigfest in Bremen")
    private String shortDescription;


    @Schema(description = "Event's place", example = "Berlin, Kirchweg str., 13")
    private String address;

    @Schema(description = "Events author", example = "Georg")
    private String author;

    @Schema(description = "Planned number of participants", example = "182")
    private Integer quantityOfMembers;//int

    @Schema(description = "Address of photo", example = "62")
    private String photo;

    @Schema(description = "Publishing start date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateStart;

    @Schema(description = "Publishing end date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateEnd;

    @Schema(description = "Location of event", example = "https://gpp/gl/maps/...")
    private String location;

    @Schema(description = "Start time of event", example = "16:00")
    private String startTime;

    @Schema(description = "End time of event", example = "18:00")
    private String endTime;


}
