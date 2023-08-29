package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateEventDto {

    @Schema(description = "New events title", example = "Some event's title...")
    private String title;

    @Schema(description = "New event's address", example = "Berlin, Kirchweg str., 13")
    private String address;

    @Schema(description = "New events author", example = "Andrii")
    private String author;


    @Schema(description = "New events status - EXPECTED, ENDED, ARCHIVE ", example = "EXPECTED")
    private String status;

    @Schema(description = "New events description", example = "Wash car")
    private String description;

    @Schema(description = "New short events description", example = "Wash car")
    private String shortDescription;

  @Schema(description = "New short events description", example = "Wash car")
    private String newShortDescription;

    @Schema(description = "New location of event", example = "https://gpp/gl/maps/...")
    private String location;


//    @Schema(description = "Planned number of participants", example = "182")
//    private String quantityOfMembers;//int

    @Schema(description = "New address of photo", example = "./src/photo/photo12.png")
    private String photo;


    @Schema(description = "Publishing start date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateStart;

    @Schema(description = "Publishing End date in format YYYY-MM-DD", example = "2022-02-02")
    private String dateEnd;

    @Schema(description = "Start time of event", example = "16:00")
    private String startTime;

    @Schema(description = "End time of event", example = "18:00")
    private String endTime;


}
