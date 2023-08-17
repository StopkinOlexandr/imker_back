package de.imker.validation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation error")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationErrorDto {
  @Schema(description = "Validation error field", example = "email")
  private String field;

  @Schema(description = "Error message", example = "must be a well-formed email address")
  private String message;

  @Schema(description = "Received form client", example = "abc.def.com")
  private String rejectedValue;
}
