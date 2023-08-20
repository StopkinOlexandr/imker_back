package de.imker.controllers;

import de.imker.controllers.api.EventsApi;
import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.UpdateEventDto;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<EventsDto> getAllEvents(Integer page, String orderBy, Boolean desc, String filterBy, String filterValue) {
        return ResponseEntity.ok((eventsService.getAllEvents(page, orderBy, desc, filterBy, filterValue)));
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
    public ResponseEntity<EventsDto> getEventsOfUser(Long userId) {
        return ResponseEntity
                .ok(eventsService.getEventsOfUser(userId));
    }

    @Override
    public ResponseEntity<EventDto> getEventById(Long eventId) {
        return ResponseEntity
                .ok(eventsService.getEventById(eventId));
    }


}
