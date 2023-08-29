package de.imker.repositories;


import de.imker.models.EventFollow;
import de.imker.models.FileUpload;
import de.imker.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersOnEventsRepository extends JpaRepository <EventFollow, Long> {

    //entFollow findAllByUser_id(Long userId);
}
