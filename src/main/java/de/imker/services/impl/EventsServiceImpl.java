package de.imker.services.impl;


import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.UpdateEventDto;
import de.imker.exeptions.ForbiddenFieldException;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Event;
import de.imker.repositories.EventsRepository;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static de.imker.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Value("${events.sort.fields}")
    private List<String> sortFields;

    @Value("${events.filter.fields}")
    private List<String> filterFields;

    @Value("${events.page.size}")
    private Integer pageSize;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .title(newEvent.getTitle())
                .description(newEvent.getDescription())
                .shortDescription(newEvent.getShortDescription())
                .address(newEvent.getAddress())
                .author(newEvent.getAuthor())
                .quantityOfMembers(newEvent.getQuantityOfMembers())
                .photo(newEvent.getPhoto())
                .dateStart(newEvent.getDateStart())
                .dateEnd(newEvent.getDateEnd())
                .startTime(newEvent.getStartTime())
                .endTime(newEvent.getEndTime())
                .location(newEvent.getLocation())
                .status(Event.Status.EXPECTED)
                .build();
        eventsRepository.save(event);
        return from(event);
    }

    @Override
    public EventsDto getAllEvents(Integer pageNumber, String orderByField, Boolean desc, String filterBy, String filterValue) {
        PageRequest pageRequest = getPageRequest(pageNumber, orderByField, desc);
        Page<Event> page = getEventsPage(filterBy, filterValue, pageRequest);
        return EventsDto.builder()
                .events(from(page.getContent()))
                .count((int) page.getTotalElements())
                .eventsCount(page.getTotalPages())
                .build();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        Event event = getEventOrThrow(eventId);
        eventsRepository.delete(event);
        return from(event);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto eventWithUpdatedData) {
        Event eventToUpdate = getEventOrThrow(eventId);

        if (!Objects.equals(eventToUpdate.getTitle(), eventWithUpdatedData.getNewTitle()) &&
                !(eventWithUpdatedData.getNewTitle().isEmpty() && eventWithUpdatedData.getNewTitle().isBlank()))
            eventToUpdate.setTitle(eventWithUpdatedData.getNewTitle());

        if (!Objects.equals(eventToUpdate.getDescription(), eventWithUpdatedData.getNewDescription()) &&
                !(eventWithUpdatedData.getNewDescription().isBlank() && eventWithUpdatedData.getNewDescription().isEmpty()))
            eventToUpdate.setDescription(eventWithUpdatedData.getNewDescription());

        if (!Objects.equals(eventToUpdate.getShortDescription(), eventWithUpdatedData.getNewShortDescription()) &&
                !(eventWithUpdatedData.getNewShortDescription().isBlank() && eventWithUpdatedData.getNewShortDescription().isEmpty()))
            eventToUpdate.setShortDescription(eventWithUpdatedData.getNewShortDescription());


        if (!Objects.equals(eventToUpdate.getAddress(), eventWithUpdatedData.getNewAddress()) &&
                !(eventWithUpdatedData.getNewAddress().isBlank() && eventWithUpdatedData.getNewAddress().isEmpty()))
            eventToUpdate.setAddress(eventWithUpdatedData.getNewAddress());


        if (!Objects.equals(eventToUpdate.getAuthor(), eventWithUpdatedData.getNewAuthor()) &&
                !(eventWithUpdatedData.getNewAuthor().isEmpty() && eventWithUpdatedData.getNewAuthor().isBlank()))
            eventToUpdate.setAuthor(eventWithUpdatedData.getNewAuthor());

        if (!Objects.equals(eventToUpdate.getLocation(), eventWithUpdatedData.getNewLocation()) &&
                !(eventWithUpdatedData.getNewLocation().isBlank() && eventWithUpdatedData.getNewLocation().isEmpty()))
            eventToUpdate.setLocation(eventWithUpdatedData.getNewLocation());

        if (!Objects.equals(eventToUpdate.getPhoto(), eventWithUpdatedData.getNewPhoto()) &&
                !(eventWithUpdatedData.getNewPhoto().isEmpty() && eventWithUpdatedData.getNewPhoto().isBlank()))
            eventToUpdate.setPhoto(eventWithUpdatedData.getNewPhoto());

        if (!Objects.equals(eventToUpdate.getDateStart(), eventWithUpdatedData.getNewDateStart()) &&
                !(eventWithUpdatedData.getNewDateStart().isEmpty() && eventWithUpdatedData.getNewDateStart().isBlank()))
            eventToUpdate.setDateStart(eventWithUpdatedData.getNewDateStart());

        if (!Objects.equals(eventToUpdate.getDateEnd(), eventWithUpdatedData.getNewDateEnd()) &&
                !(eventWithUpdatedData.getNewDateEnd().isEmpty() && eventWithUpdatedData.getNewDateEnd().isBlank()))
            eventToUpdate.setDateEnd(eventWithUpdatedData.getNewDateEnd());

        if (!Objects.equals(eventToUpdate.getStartTime(), eventWithUpdatedData.getNewStartTime()) &&
                !(eventWithUpdatedData.getNewStartTime().isEmpty() && eventWithUpdatedData.getNewStartTime().isBlank()))
            eventToUpdate.setStartTime(eventWithUpdatedData.getNewStartTime());

        if (!Objects.equals(eventToUpdate.getEndTime(), eventWithUpdatedData.getNewEndTime()) &&
                !(eventWithUpdatedData.getNewEndTime().isBlank() && eventWithUpdatedData.getNewEndTime().isEmpty()))
            eventToUpdate.setEndTime(eventWithUpdatedData.getNewEndTime());

        if (!Objects.equals(eventToUpdate.getStatus(), eventWithUpdatedData.getNewStatus()) &&
                !(eventWithUpdatedData.getNewStatus().isBlank() && eventWithUpdatedData.getNewStatus().isEmpty()))
            eventToUpdate.setStatus(Event.Status.valueOf(eventWithUpdatedData.getNewStatus()));

        eventsRepository.save(eventToUpdate);
        return from(eventToUpdate);
    }

    @Override
    public EventsDto getEventsOfUser(Long eventId) {
        Event event = getEventOrThrow(eventId);
//        return EventsDto.builder()
//                .events(from(event.getEvents()))
//                .count(event.getEvents().size())
//                .build();

        return null;
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Event event = getEventOrThrow(eventId);
        return EventDto.builder()
                .idEvent(event.getEventId())
                .title(event.getTitle())
                .description(event.getDescription())
                .shortDescription(event.getShortDescription())
                .status(event.getStatus().toString())
                .address(event.getAddress())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .author(event.getAuthor())
                .dateStart(event.getDateStart())
                .dateEnd(event.getDateEnd())
                .location(event.getLocation())
                .photo(event.getPhoto())
                .build();
    }

    private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc) {

        if (orderByField != null && !orderByField.equals("")) {

            checkField(sortFields, orderByField);

            Sort.Direction direction = Sort.Direction.ASC;

            if (desc != null && desc) {
                direction = Sort.Direction.DESC;
            }

            Sort sort = Sort.by(direction, orderByField);

            return PageRequest.of(pageNumber, pageSize, sort);
        } else {
            return getDefaultPageRequest(pageNumber);
        }
    }

    private PageRequest getDefaultPageRequest(Integer pageNumber) {
        return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
    }

    private void checkField(List<String> allowedFields, String field) {
        if (!allowedFields.contains(field)) {
            throw new ForbiddenFieldException(field);
        }
    }


    private Page<Event> getEventsPage(String filterBy, String filterValue, PageRequest pageRequest) {

        Page<Event> page = Page.empty();
        if (filterBy == null || filterFields.equals("")) {
            page = eventsRepository.findAll(pageRequest);
        } else {
            checkField(filterFields, filterBy);
            if (filterBy.equals("startTime")) {
                // String date = filterValue;
                page = eventsRepository.findAllByStartTime(filterValue, pageRequest);

            } else if (filterBy.equals("endTime")) {
                //  LocalDate date = LocalDate.parse(filterValue);
                page = eventsRepository.findAllByEndTime(filterValue, pageRequest);
            } else if (filterBy.equals("dateStart")) {

                page = eventsRepository.findAllByDateStart(filterValue, pageRequest);
            }

        }
        return page;
    }

    private Event getEventOrThrow(Long eventId) {
        return eventsRepository.findById(eventId).orElseThrow(
                () -> new NotFoundException("Event with: " + eventId + " not found "));
    }
}