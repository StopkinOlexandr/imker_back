package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "All requests")
public class RequestsDto {
  @Schema(description = "List of requests")
  private List<RequestDto> requests;
  @Schema(description = "Total amount", example = "1")
  private Integer count;
}
