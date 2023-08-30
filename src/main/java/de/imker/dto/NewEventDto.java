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
    @Schema(description = "Even's title", example = "Title about event...")
    private String title;

    @NotNull
    @NotBlank
    @Schema(description = "Description of event", example = "Ex. dress-code, or food")
    private String description;

    @NotNull
    @NotBlank
    @Schema(description = "Short description of event", example = "Ex. dress-code, or food")
    private String shortDescription;


    @Schema(description = "Event's place", example = "Berlin, Kirchweg str., 13")
    private String address;

    @Schema(description = "Events author", example = "Andrii")
    private String author;

    @Schema(description = "Planned number of participants", example = "182")
    private Integer quantityOfMembers;//int

    @Schema(description = "Address of photo", example = "./src/photo/photo12.png")
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
