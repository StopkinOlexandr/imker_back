package de.imker.services.impl;

import de.imker.dto.GoogleMapDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.GoogleMap;
import de.imker.repositories.GoogleMapRepository;
import de.imker.services.GoogleMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class GoogleMapServiceImpl implements GoogleMapService {
  private final GoogleMapRepository googleMapRepository;

  @Override
  public GoogleMapDto getGoogleMapLink() {
    GoogleMap link = getLinkOrThrow();

    return GoogleMapDto.builder()
        .id(link.getId())
        .googleMapLink(link.getGoogleMapLink())
        .build();
  }

  private GoogleMap getLinkOrThrow() {
    return googleMapRepository.getGoogleMapLinkById(1L).orElseThrow(
        () -> new NotFoundException("Link not found"));
  }
}

