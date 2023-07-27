package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
  private Long idRequest;
  private String firstNameRequest;
  private String lastNameRequest;
  private String emailRequest;
  private String phoneRequest;
  private String textOfRequest;
}
