package de.imker.services.impl;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;
import de.imker.models.Request;
import de.imker.repositories.RequestsRepository;
import de.imker.services.RequestsService;
import de.imker.services.telegrammNotice.TelegramNotice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RequestsServicePostgresImpl implements RequestsService {
  private final RequestsRepository requestsRepository;

  @Override
  public RequestDto addRequest(NewRequestDto newRequest) {
    Request request = Request.builder()
        .firstNameRequest(newRequest.getFirstName())
        .lastNameRequest(newRequest.getLastName())
        .emailRequest(newRequest.getEmail())
        .phoneRequest(newRequest.getPhoneNumber())
        .textOfRequest(newRequest.getQuestionText())
        .build();
    requestsRepository.save(request);

    String message = String.format("""
        There is a new request:

          First name: %s
          Last name: %s
          Email: %s
          PhoneNumber: %s
          
          Request text: %s
        """,request.getFirstNameRequest(),
        request.getLastNameRequest(),
        request.getEmailRequest(),
        request.getPhoneRequest(),
        request.getTextOfRequest());
    TelegramNotice.sendTelegramNotice(message);
    return RequestDto.from(request);
  }

  @Override
  public RequestsDto findAll() {
    List<Request> requests = requestsRepository.findAll();
    return RequestsDto.builder()
        .requests(RequestDto.from(requests))
        .count(requests.size())
        .build();
  }
}
