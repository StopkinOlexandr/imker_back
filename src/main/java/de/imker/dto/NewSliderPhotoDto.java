package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data for new slider photo")
public class NewSliderPhotoDto {

  @Schema(description = "Id of title image file in DB", example = "1")
  private Long linkToImg;

}
