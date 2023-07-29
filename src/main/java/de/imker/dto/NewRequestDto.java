package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Data for creating a request")
public class NewRequestDto {
  @Schema(description = "User first name", example = "John")
  private String firstName;
  @Schema(description = "User last name", example = "Smith")
  private String lastName;
  @Schema(description = "User email", example = "JohnS@gmail.com")
  private String email;
  @Schema(description = "User phone number", example = "+4 9(123) 456 7890")
  private String phoneNumber;
  @Schema(description = "Request text (max 150 characters)", example = "Lorem ipsum, dolor...")
  private String questionText;
}
