package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Users events")
public class EventsDto {

    @Schema(description = "List of events")
    private List<EventDto> events;

    @Schema(description = "Quantity of users events")
    private Integer count;

    @Schema(description = "Events Count", example = "3")
    private Integer eventsCount;
}


