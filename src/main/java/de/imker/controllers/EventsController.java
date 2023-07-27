package de.imker.controllers;

import de.imker.controllers.api.EventsApi;
import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.UpdateEventDto;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public EventDto addEvent(@RequestBody NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }

    @Override
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        return eventsService.deleteEvent(eventId);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return eventsService.updateEvent(eventId,updateEvent);
    }


}
