package de.imker.repositories;

import de.imker.models.GoogleMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoogleMapRepository extends JpaRepository<GoogleMap, Long> {
  Optional<GoogleMap> getGoogleMapLinkById(Long id);
}
