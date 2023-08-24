package de.imker.controllers;

import de.imker.controllers.api.GoogleMapApi;
import de.imker.dto.GoogleMapDto;
import de.imker.services.GoogleMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GoogleMapController implements GoogleMapApi {
  private final GoogleMapService googleMapService;

  @Override
  public GoogleMapDto getGoogleMapLink() {
    return googleMapService.getGoogleMapLink();
  }

  @Override
  public GoogleMapDto updateGoogleMapLink(GoogleMapDto newLink) {
    return googleMapService.updateGoogleMapLink(newLink);
  }
}
