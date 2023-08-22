package de.imker.dto;

import de.imker.models.GoogleMap;
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
      example = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2416.3096482125134!2d9.61041657185848!3d52.72660458996256!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47b05c9680b0b6d1%3A0x56f0e67cfd5ecb98!2sWalsroder%20Str.%203%2C%2029693%20Eickeloh!5e0!3m2!1sru!2sde!4v1690814421367!5m2!1sru!2sde")
  private String googleMapLink;

  public static GoogleMapDto from(GoogleMap googleMap) {
    return GoogleMapDto.builder()
        .id(googleMap.getId())
        .googleMapLink(googleMap.getGoogleMapLink())
        .build();
  }
}
