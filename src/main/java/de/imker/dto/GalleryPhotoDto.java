package de.imker.dto;

import de.imker.models.GalleryPhoto;
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
@Schema(description = "Gallery photo info")
public class GalleryPhotoDto {

  @Schema(description = "Photo ID in DB", example = "1")
  private Long id;
  @Schema(description = "Time of photo loading", example = "yyyy-MM-dd HH:mm:ss")
  private Date creationTime;
  @Schema(description = "Id of photo file in DB", example = "1")
  private Long linkToImg;

  public static GalleryPhotoDto from(GalleryPhoto galleryPhoto) {
    return GalleryPhotoDto.builder()
        .id(galleryPhoto.getId())
        .creationTime(galleryPhoto.getCreationTimePhoto())
        .linkToImg(galleryPhoto.getLinkToImg())
        .build();
  }

  public static List<GalleryPhotoDto> from(List<GalleryPhoto> photos) {
    return photos.stream()
        .map(GalleryPhotoDto::from)
        .collect(Collectors.toList());
  }
}
