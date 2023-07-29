package de.imker.controllers;

import de.imker.controllers.api.RequestsApi;
import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;
import de.imker.services.RequestsService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RequestsController implements RequestsApi {
  private final RequestsService requestsService;

@Override
  public RequestDto addRequest(@Parameter(required = true, description = "Request")
                                 @RequestBody NewRequestDto newRequest){
    return requestsService.addRequest(newRequest);
  }

@Override
  public RequestsDto getAllRequests(){
    return requestsService.findAll();
  }

  @Override
  public RequestDto deleteRequest(Long idRequest) {
    return requestsService.removeById(idRequest);
  }


}
