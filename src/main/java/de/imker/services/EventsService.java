package de.imker.services;


import de.imker.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);


    EventsDto getAllEvents(Integer page, Integer pageSize, String orderBy, Boolean desc, String filterBy, String filterValue);

    EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);


    EventDto getEventById(Long eventId);


    EventFollowDto followEventById(Long eventId);


    EventsDto getAllTimeEvents();

    EventsList getMyEventsList();

    UsersList getUsersListByEventId(Long eventId);

    EventFollowDto unfollowEventById(Long eventId);
}
