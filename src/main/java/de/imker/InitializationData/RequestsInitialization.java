package de.imker.InitializationData;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestsDto;
import de.imker.repositories.RequestsRepository;
import de.imker.services.impl.RequestsServicePostgresImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestsInitialization {
  private final RequestsServicePostgresImpl requestsService;

  @Autowired
  public RequestsInitialization(RequestsRepository requestsRepository) {
    this.requestsService = new RequestsServicePostgresImpl(requestsRepository);
  }

  public void reqInit() {
    RequestsDto requestsDto = requestsService.findAll();
    if (requestsDto.getRequests().size() == 0) {
      NewRequestDto request = NewRequestDto.builder()
          .firstName("John")
          .lastName("Smith")
          .email("john.smith@example.com")
          .phoneNumber("+4 9(123) 456-7890")
          .questionText("Hey beekeeping community! I'm curious about the best practices for " +
              "preventing swarming in my beehives. Any tips on swarm management and how to keep " +
              "my colonies happy and thriving? Thanks in advance for your expertise!")
          .build();
      requestsService.addRequest(request);

      request = NewRequestDto.builder()
          .firstName("Anna")
          .lastName("Müller")
          .email("anna.mueller@email.de")
          .phoneNumber("+4 9(987) 654-3210")
          .questionText("Hi there fellow beekeepers! I'm a novice and could use some guidance " +
              "on dealing with mites in my bee colonies. Any recommendations for natural and " +
              "effective mite treatments would be greatly appreciated. Looking forward to " +
              "your insights!")
          .build();
      requestsService.addRequest(request);

      request = NewRequestDto.builder()
          .firstName("Robert")
          .lastName("Schmidt")
          .email("robert.schmidt@example.com")
          .phoneNumber("+4 9(555) 123-4567")
          .questionText("Greetings everyone! I've been experimenting with different hive designs " +
              "and I'm curious if anyone has experience with top-bar hives. I'd love to hear " +
              "your thoughts and experiences with this type of hive. Thanks for sharing!")
          .build();
      requestsService.addRequest(request);

      request = NewRequestDto.builder()
          .firstName("Sophie")
          .lastName("Waginer")
          .email("sophie.wagner@email.com")
          .phoneNumber("+4 9(999) 888-7777")
          .questionText("Hello beekeeping community! I'm considering starting my own honey " +
              "business and I'm looking for advice on branding and marketing honey products. " +
              "If you have any insights on packaging, labeling, or reaching customers, please " +
              "let me know. Excited to embark on this sweet venture!")
          .build();
      requestsService.addRequest(request);

      request = NewRequestDto.builder()
          .firstName("Michael")
          .lastName("Fischer")
          .email("michael.fischer@mail.de")
          .phoneNumber("+4 9(111) 222-3333")
          .questionText("Hi beekeepers! I've recently noticed a decline in pollinators visiting " +
              "my garden. I'd love to hear your suggestions on creating a pollinator-friendly " +
              "environment and attracting bees and butterflies. Let's work together to support " +
              "our buzzing friends and the environment!")
          .build();
      requestsService.addRequest(request);
    }
  }
}
