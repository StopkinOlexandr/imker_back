package de.imker.controllers;

import de.imker.controllers.api.EventsApi;
import de.imker.dto.*;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public ResponseEntity<EventDto> addEvent(NewEventDto newEvent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventsService.addEvent(newEvent));
    }



    @Override
    public EventsDto getAllEvents(Integer page, Integer pageSize, String orderBy, Boolean desc, String filterBy, String filterValue) {
        return eventsService.getAllEvents(page, pageSize, orderBy, desc, filterBy, filterValue);
    }


    @Override
    public ResponseEntity<EventDto> deleteEvent(Long eventId) {
        return ResponseEntity
                .ok(eventsService.deleteEvent(eventId));
    }

    @Override
    public ResponseEntity<EventDto> updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return ResponseEntity
                .ok(eventsService.updateEvent(eventId, updateEvent));
    }

    @Override
    public ResponseEntity<EventDto> getEventById(Long eventId) {
        return ResponseEntity
                .ok(eventsService.getEventById(eventId));
    }

    @Override
    public ResponseEntity<EventFollowDto> followEventById(Long eventId) {
        return ResponseEntity
                .ok(eventsService.followEventById(eventId));
    }

     @Override
    public EventsDto getAllTimeEvents() {
        return eventsService.getAllTimeEvents();
    }

    @Override
    public ResponseEntity<EventsList> getMyEventsList() {
        return ResponseEntity
            .ok(eventsService.getMyEventsList());
    }

    @Override
    public ResponseEntity<UsersList> getUsersListByEventId(Long eventId) {
        return ResponseEntity
            .ok(eventsService.getUsersListByEventId(eventId));
    }

    @Override
    public ResponseEntity<EventFollowDto> unfollowEventById(Long eventId) {
        return ResponseEntity
            .ok(eventsService.unfollowEventById(eventId));
    }


}
