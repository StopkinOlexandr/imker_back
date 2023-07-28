package de.imker.repositories;

import de.imker.dto.RequestsDto;
import de.imker.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Request, Long> {

}
