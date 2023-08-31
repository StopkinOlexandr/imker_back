package de.imker.services.impl;

import de.imker.dto.*;
import de.imker.exeptions.ForbiddenFieldException;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Event;
import de.imker.models.User;
import de.imker.repositories.EventsRepository;
import de.imker.repositories.UsersRepository;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static de.imker.dto.EventDto.from;


@RequiredArgsConstructor
@Transactional
@Service
public class EventsServiceImpl implements EventsService {

  private final EventsRepository eventsRepository;
  private final UsersRepository usersRepository;
  private final UsersServiceImpl usersService;

  @Value("${events.sort.fields}")
  private List<String> sortFields;

  @Value("${events.filter.fields}")
  private List<String> filterFields;


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
  public EventsDto getAllEvents(Integer pageNumber, Integer pageSize, String orderByField, Boolean desc, String filterBy, String filterValue) {
    PageRequest pageRequest = getPageRequest(pageNumber, orderByField, desc, pageSize);
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

    if (!Objects.equals(eventToUpdate.getTitle(), eventWithUpdatedData.getTitle()) &&
        !(eventWithUpdatedData.getTitle().isEmpty() && eventWithUpdatedData.getTitle().isBlank())) {
      eventToUpdate.setTitle(eventWithUpdatedData.getTitle());
    }

    if (!Objects.equals(eventToUpdate.getDescription(), eventWithUpdatedData.getDescription()) &&
        !(eventWithUpdatedData.getDescription().isBlank() && eventWithUpdatedData.getDescription().isEmpty())) {
      eventToUpdate.setDescription(eventWithUpdatedData.getDescription());
    }

    if (!Objects.equals(eventToUpdate.getShortDescription(), eventWithUpdatedData.getShortDescription()) &&
        !(eventWithUpdatedData.getShortDescription().isBlank() && eventWithUpdatedData.getShortDescription().isEmpty())) {
      eventToUpdate.setShortDescription(eventWithUpdatedData.getShortDescription());
    }


    if (!Objects.equals(eventToUpdate.getAddress(), eventWithUpdatedData.getAddress()) &&
        !(eventWithUpdatedData.getAddress().isBlank() && eventWithUpdatedData.getAddress().isEmpty())) {
      eventToUpdate.setAddress(eventWithUpdatedData.getAddress());
    }


    if (!Objects.equals(eventToUpdate.getAuthor(), eventWithUpdatedData.getAuthor()) &&
        !(eventWithUpdatedData.getAuthor().isEmpty() && eventWithUpdatedData.getAuthor().isBlank())) {
      eventToUpdate.setAuthor(eventWithUpdatedData.getAuthor());
    }

    if (!Objects.equals(eventToUpdate.getLocation(), eventWithUpdatedData.getLocation()) &&
        !(eventWithUpdatedData.getLocation().isBlank() && eventWithUpdatedData.getLocation().isEmpty())) {
      eventToUpdate.setLocation(eventWithUpdatedData.getLocation());
    }

    if (!Objects.equals(eventToUpdate.getPhoto(), eventWithUpdatedData.getPhoto()) &&
        !(eventWithUpdatedData.getPhoto().isEmpty() && eventWithUpdatedData.getPhoto().isBlank())) {
      eventToUpdate.setPhoto(eventWithUpdatedData.getPhoto());
    }

    if (!Objects.equals(eventToUpdate.getDateStart(), eventWithUpdatedData.getDateStart()) &&
        !(eventWithUpdatedData.getDateStart().isEmpty() && eventWithUpdatedData.getDateStart().isBlank())) {
      eventToUpdate.setDateStart(eventWithUpdatedData.getDateStart());
    }

    if (!Objects.equals(eventToUpdate.getDateEnd(), eventWithUpdatedData.getDateEnd()) &&
        !(eventWithUpdatedData.getDateEnd().isEmpty() && eventWithUpdatedData.getDateEnd().isBlank())) {
      eventToUpdate.setDateEnd(eventWithUpdatedData.getDateEnd());
    }

    if (!Objects.equals(eventToUpdate.getStartTime(), eventWithUpdatedData.getStartTime()) &&
        !(eventWithUpdatedData.getStartTime().isEmpty() && eventWithUpdatedData.getStartTime().isBlank())) {
      eventToUpdate.setStartTime(eventWithUpdatedData.getStartTime());
    }

    if (!Objects.equals(eventToUpdate.getEndTime(), eventWithUpdatedData.getEndTime()) &&
        !(eventWithUpdatedData.getEndTime().isBlank() && eventWithUpdatedData.getEndTime().isEmpty())) {
      eventToUpdate.setEndTime(eventWithUpdatedData.getEndTime());
    }


    if (!Objects.equals(eventToUpdate.getStatus(), eventWithUpdatedData.getStatus()) &&
        !(eventWithUpdatedData.getStatus().isBlank() && eventWithUpdatedData.getStatus().isEmpty())) {
      eventToUpdate.setStatus(Event.Status.valueOf(eventWithUpdatedData.getStatus()));
    }

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
        .idEvent(event.getId())
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


  private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc, Integer pageSize) {

    if (orderByField != null && !orderByField.equals("")) {

      checkField(sortFields, orderByField);

      Sort.Direction direction = Sort.Direction.ASC;

      if (desc != null && desc) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderByField);

      return PageRequest.of(pageNumber, pageSize, sort);
    } else {
      return getDefaultPageRequest(pageNumber, pageSize);
    }
  }

  private PageRequest getDefaultPageRequest(Integer pageNumber, Integer pageSize) {
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


  @Override
  public EventFollowDto followEventById(Long eventsId) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    User user = usersRepository.findByEmail(authentication.getName()).orElseThrow(
        () -> new NotFoundException("User not found"));

    Event event = getEventOrThrow(eventsId);

    if (user != null && event != null && !userHasEvent(user, event)) {
      user.getEvents().add(event);
      usersRepository.save(user);
    }
    assert user != null;

    return EventFollowDto.builder()
        .idEvent(eventsId)
        .idUser(user.getId())
        .followedStatus(true)
        .build();
  }

  private boolean userHasEvent(User user, Event event) {
    return user.getEvents().contains(event);
  }


//        Event followedEvent = getEventOrThrow(eventId);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        UserDto userEntity = usersService.findByEmail(currentPrincipalName);
//        Long userId = userEntity.getId();
//
//        // System.out.println("Find all " + usersOnEventsRepository.findAllByUser_id(userId));
//
//        EventFollow eventFollow = EventFollow.builder()
//                .event_id(followedEvent.getId())
//                .user_id(userId)
//                .followedStatus(true)
//                .build();
//
//        followedEvent.setQuantityOfMembers(followedEvent.getQuantityOfMembers() + 1);
//        usersOnEventsRepository.save(eventFollow);
//
//        return EventFollowDto.from(eventFollow);

//  @Override
//  public EventFollowDto deleteFollowedEvent(Long followedId) {
//    EventFollow eventFollow = usersOnEventsRepository.findById(followedId).orElseThrow(
//        () -> new NotFoundException("Follower with: " + followedId + " not found "));
//    usersOnEventsRepository.delete(eventFollow);
//    return EventFollowDto.from(eventFollow);
//  }


///TODO Delete get all by user Id, get usersByEvent ID   JPA REP - search is exist


}