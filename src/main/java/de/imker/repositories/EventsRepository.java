package de.imker.repositories;


import de.imker.models.Event;
import okhttp3.internal.concurrent.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EventsRepository extends JpaRepository<Event,Long> {

    Page<Event> findAllByStartTime(String startTime, Pageable pageable);
    Page<Event> findAllByDateStart(String dateStart, Pageable pageable);
   Page<Event> findAllByEndTime(String endTime, Pageable pageable);



}

