package de.imker.dto;

import de.imker.models.AboutUs;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "About Us Description")
public class AboutUsDto {

  @Schema(description = "Identification", example = "1")
  private Integer id;
  @Schema(description = "Title Top", example = "Our story")
  private String titleTop;
  @Schema(description = "Ddescrption Top", example = "")
  private String descriptionTop;
  @Schema(description = "Title Bottom", example = "")
  private String titleBottom;
  @Schema(description = "Ddescrption Bottom", example = "")
  private String descriptionBottom;
  @Schema(description = "Image №1 for article", example = "7")
  private String image1;
  @Schema(description = "Image №2 for article", example = "12")
  private String image2;

  public static AboutUsDto transformAboutUsToAboutUsDto(AboutUs aboutUs) {
    return AboutUsDto.builder()
        .id(aboutUs.getId())
        .titleTop(aboutUs.getTitleTop())
        .descriptionTop(aboutUs.getDescriptionTop())
        .titleBottom(aboutUs.getTitleBottom())
        .descriptionBottom(aboutUs.getDescriptionBottom())
        .image1(aboutUs.getImage1())
        .image2(aboutUs.getImage2())
        .build();
  }
}
