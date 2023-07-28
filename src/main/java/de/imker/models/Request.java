package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requests")
public class Request {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idRequest;

  private String firstNameRequest;
  private String lastNameRequest;
  private String emailRequest;
  private String phoneRequest;
  private String textOfRequest;
}
