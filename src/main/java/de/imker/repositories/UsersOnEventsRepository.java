package de.imker.repositories;


import de.imker.models.EventFollow;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersOnEventsRepository extends JpaRepository <EventFollow, Long> {


}
