package de.imker.services;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;

public interface RequestsService {
  RequestDto addRequest(NewRequestDto newRequest);

  RequestsDto findAll();

  RequestDto removeById(Long id);

}
