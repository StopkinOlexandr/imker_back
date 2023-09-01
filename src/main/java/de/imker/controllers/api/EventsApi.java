package de.imker.controllers.api;

import de.imker.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
        @Tag(name = "Events")
})
@RequestMapping("/api/events")

public interface EventsApi {
    @Operation(summary = "Add event", description = "Admin access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Cant find user with this ID",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    }),
            @ApiResponse(responseCode = "201", description = "Event added",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EventDto> addEvent(@Parameter(required = true, description = "Event") @RequestBody @Valid NewEventDto newEvent);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Events list",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventsDto.class))
                    }),
            @ApiResponse(responseCode = "403", description = "Attempt to sort by a forbidden field",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    @Operation(summary = "Get All Events", description = "Full access")
    @GetMapping
    EventsDto getAllEvents(
            @Parameter(description = "Page number", example = "1")
            @RequestParam(value = "page") Integer page,
            @Parameter(description = "Page size", example = "4")
            @RequestParam(value = "pageSize") Integer pageSize,
            @Parameter(description = "Sort field. Enable:something")
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @Parameter(description = "If True -> DESC")
            @RequestParam(value = "desc", required = false) Boolean desc,
            @RequestParam(value = "filterBy", required = false) String filterBy,
            @RequestParam(value = "filterValue", required = false) String filterValue);


    @Operation(summary = "Delete Event", description = "Only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "Delete event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @DeleteMapping("/{event-id}")
    ResponseEntity<EventDto> deleteEvent(@Parameter(required = true, description = "ID to delete", example = "2") @PathVariable("event-id") Long eventId);

    @Operation(summary = "Update Event", description = "Update available only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "200", description = "Updated event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @PutMapping("/{event-id}")
    ResponseEntity<EventDto> updateEvent(@Parameter(required = true, description = "ID to update", example = "2")
                                         @PathVariable("event-id") Long eventId,
                                         @RequestBody UpdateEventDto updateEvent);

    @Operation(summary = "Get event by ID", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Event not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Event found ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @GetMapping("/{event-id}")
    ResponseEntity<EventDto> getEventById(@Parameter(required = true, description = "Event ID", example = "1")
                                          @PathVariable("event-id") Long eventId);

    @Operation(summary = "Follow Event", description = "Follow available only for members")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "200", description = "Follow event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventFollowDto.class))
                    })
    })
    @PutMapping("/{event-id}/follow")
    ResponseEntity<EventFollowDto> followEventById(@Parameter(required = true, description = "ID to follow", example = "2")
                                               @PathVariable("event-id") Long eventId);

    @Operation(summary = "Get All Time Events", description = "Full access")
    @GetMapping("/getAll")
    EventsDto getAllTimeEvents();

    @Operation(summary = "Get events list", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Events not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Events found ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @GetMapping("/myeventslist")
    ResponseEntity<EventsList> getMyEventsList();

    @Operation(summary = "Get users list by event ID", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Event not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Event found ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @GetMapping("/{event-id}/users")
    ResponseEntity<UsersList> getUsersListByEventId(@Parameter(required = true, description = "Event ID", example = "1")
                                                    @PathVariable("event-id") Long eventId);

    @Operation(summary = "Unfollow event by id", description = "Only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "follow on event deleted",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventFollowDto.class))
                    })
    })
    @DeleteMapping("/{event-id}/unfollow")
    ResponseEntity<EventFollowDto> unfollowEventById(@Parameter(required = true, description = "ID to delete", example = "2")
                                                     @PathVariable("event-id") Long eventId);

}
