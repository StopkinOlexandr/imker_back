package de.imker.services.impl;


import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.UpdateEventDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Event;
import de.imker.repositories.EventsRepository;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import static de.imker.dto.EventDto.from;
@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .name(newEvent.getName())
                .description(newEvent.getDescription())
                .place(newEvent.getPlace())
                .author(newEvent.getAuthor())
                .quantityOfMembers(newEvent.getQuantityOfMembers())
                .photo(newEvent.getPhoto())
                .date(newEvent.getDate())
                .status(Event.Status.EXPECTED).build();
        eventsRepository.saveEvent(event);
        return EventDto.from(event);
    }

    @Override
    public EventsDto getAllEvents() {
        List<Event> events = eventsRepository.findAllEvents();
        return EventsDto.builder()
                .events(from(events))
                .count(events.size())
                .build();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
//        Optional<Event> event = eventsRepository.findById(eventId);
//        if (event.isEmpty()) {
//            throw new NotFoundException("Event with id <" + eventId + "> not found");
//        }
//        eventsRepository.delete(event.get());
        Event event = getEventFromRepository(eventId);

        eventsRepository.delete(event);
        return from(event);
    }


    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        Event event = getEventFromRepository(eventId);
        event.setStatus(Event.Status.valueOf(updateEvent.getNewStatus()));
        //TODO change place

        eventsRepository.saveEvent(event);
        return from(event);
    }

    private Event getEventFromRepository(Long eventId) {
        return eventsRepository.findById(eventId).orElseThrow(
                () -> new NotFoundException("Event with id <" + eventId + "> not found"));
    }
}
