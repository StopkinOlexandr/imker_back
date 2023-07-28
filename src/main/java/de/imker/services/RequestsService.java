package de.imker.services;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;
import de.imker.models.Request;

import java.util.List;

public interface RequestsService {
  RequestDto addRequest(NewRequestDto newRequest);

  public RequestsDto findAll();

}
