package de.imker.repositories;



import de.imker.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventsRepository {

    void save(Event event);
    List<Event> findAll();
    Optional<Event> findById(Long id);
    void clear();

    void delete(Event event);
}

