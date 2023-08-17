package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User ID")
@Data
public class UserIdDto {

  @Schema(description = "User's ID", example = "1")
  private Long id;
}
