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

import java.time.LocalDate;
import java.util.List;

import static de.imker.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    @Value("${events.sort.fields}")//TODO sorting
    private List<String> sortFields;

    @Value("${events.filter.fields}")
    private List<String> filterFields;

    @Value("${events.page.size}")
    private Integer pageSize;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        //User user=usersRepository.findById(newEvent.get)
        Event event = Event.builder()
                .title(newEvent.getTitle())
                .description(newEvent.getDescription())
                .address(newEvent.getAddress())
                .author(newEvent.getAuthor())
                .quantityOfMembers(newEvent.getQuantityOfMembers())
                .photo(newEvent.getPhoto())
                .date(newEvent.getDate())
                .startTime(newEvent.getStartTime())
                .endTime(newEvent.getEndTime())
                .location(newEvent.getLocation())
                .status(Event.Status.EXPECTED)
                                .build();
        eventsRepository.save(event);
        return EventDto.from(event);
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
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        Event event = getEventOrThrow(eventId);
        event.setStatus(Event.Status.valueOf(updateEvent.getNewStatus()));
        eventsRepository.save(event);
        return from(event);
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

    private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc) {

        if (orderByField != null && !orderByField.equals("")) { // проверяем, задал ли клиент поле для сортировки?

            checkField(sortFields, orderByField); // проверяем, доступно ли нам поле для сортировки

            Sort.Direction direction = Sort.Direction.ASC; // предполагаем, что сортировка будет в прямом порядке

            if (desc != null && desc) { // если клиент задал сортировку в обратном порядке
                direction = Sort.Direction.DESC; // задаем обратный порядок сортировки
            }

            Sort sort = Sort.by(direction, orderByField); // создаем объект для сортировки направление + поле

            return PageRequest.of(pageNumber, pageSize, sort); // создаем запрос на получение страницы пользователей с сортировкой
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


    private Page<Event> getEventsPage(String filterBy, String filterValue, PageRequest pageRequest) { //TODO: fix This

        Page<Event> page = Page.empty();
        if (filterBy == null || filterFields.equals("")) {
            page = eventsRepository.findAll(pageRequest);
        } else {
            checkField(filterFields, filterBy);
            if (filterBy.equals("startDate")) {
                LocalDate date = LocalDate.parse(filterValue);
                //     System.out.println("Filtering by finishDate: " + date);
                page = eventsRepository.findAllByDate(date.toString(), pageRequest);

           } //else if (filterBy.equals("finishDate")) {
//                LocalDate date = LocalDate.parse(filterValue);
//                page = eventsRepository.findAllByFinishDate(date, pageRequest);
//            }

        }
        return page;
    }

    private Event getEventOrThrow(Long eventId) {
        return eventsRepository.findById(eventId).orElseThrow(
                () -> new NotFoundException("Event with: " + eventId + " not found -delete this kostill"));//TODO Убрать костыль
    }
}