package de.imker.services;


import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.UpdateEventDto;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getAllEvents();
    EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);
    EventsDto getPaginatedEvents(int page, int size);
}
