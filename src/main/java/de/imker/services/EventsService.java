package de.imker.services;


import de.imker.dto.*;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);


    EventsDto getAllEvents(Integer page, Integer pageSize, String orderBy, Boolean desc, String filterBy, String filterValue );

    EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);

    EventsDto getEventsOfUser(Long userId);

    EventDto getEventById(Long eventId);


    EventFollowDto followEventById(Long eventId);


    EventFollowDto deleteFollowedEvent(Long followedId);
}
