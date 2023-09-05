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
@Schema(description = "List of slider photos")
public class SliderPhotosDto {

  @Schema(description = "List of slider photos")
  private List<SliderPhotoDto> photos;

  @Schema(description = "Total amount of slider photos", example = "1")
  private Integer count;

  @Schema(description = "Number of pages", example = "1")
  private Integer pages;
}
