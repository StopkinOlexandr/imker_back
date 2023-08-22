package de.imker.services;

import de.imker.dto.GoogleMapDto;

public interface GoogleMapService {

  GoogleMapDto getGoogleMapLink();

  GoogleMapDto updateGoogleMapLink(GoogleMapDto newLink);
}
