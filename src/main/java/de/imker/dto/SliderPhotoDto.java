package de.imker.dto;

import de.imker.models.GalleryPhoto;
import de.imker.models.SliderPhoto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Slider photo info")
public class SliderPhotoDto {

  @Schema(description = "Slider ID in DB", example = "1")
  private Long id;
  @Schema(description = "Time of slider loading", example = "yyyy-MM-dd HH:mm:ss")
  private Date creationTime;
  @Schema(description = "Id of slider file in DB", example = "1")
  private Long linkToImg;

  public static SliderPhotoDto from(SliderPhoto sliderPhoto) {
    return SliderPhotoDto.builder()
        .id(sliderPhoto.getId())
        .creationTime(sliderPhoto.getCreationTimeSlider())
        .linkToImg(sliderPhoto.getLinkToImg())
        .build();
  }

  public static List<SliderPhotoDto> from(List<SliderPhoto> photos) {
    return photos.stream()
        .map(SliderPhotoDto::from)
        .collect(Collectors.toList());
  }
}
