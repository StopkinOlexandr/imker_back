package de.imker.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation error")
public class ValidationErrorsDto {

  @Schema(description = "List of errors")
  private List<ValidationErrorDto> errors;
}
