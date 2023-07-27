package de.imker.repositories;



import de.imker.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventsRepository {

    void saveEvent(Event event);
    List<Event> findAllEvents();
    Optional<Event> findById(Long id);
    void clearEvents();

    void delete(Event event);
}

