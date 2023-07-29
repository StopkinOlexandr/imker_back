package de.imker.repositories;

import de.imker.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Request, Long> {

  void removeByIdRequest(Long idRequest);

}
