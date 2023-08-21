package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO for google maps link")
public class GoogleMapDto {

  @Schema(description = "ID in DB: always = 1 ", example = "1")
  private Long id;

  @Schema(description = "HTML <iframe> with google maps link",
      example = "<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d9710.93895466906!2d13.392481562341327!3d52.52013943017145!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sde!4v1692571824083!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
  private String googleMapLink;
}
