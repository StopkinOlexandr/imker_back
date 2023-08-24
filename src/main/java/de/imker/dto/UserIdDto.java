package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User ID")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdDto {

  @Schema(description = "User's ID", example = "1")
  private Long id;
}
