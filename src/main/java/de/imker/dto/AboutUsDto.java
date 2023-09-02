package de.imker.dto;

import de.imker.models.AboutUs;
import de.imker.models.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "About Us Description")
public class AboutUsDto {

  @Schema(description = "ID", example = "1")
  private Integer id;
  @Schema(description = "Title Top", example = "Our story")
  private String titleTop;
  @Schema(description = "Ddescrption Top", example = "Ein Imkerverein ist eine bedeutende Vereinigung")
  private String descriptionTop;
  @Schema(description = "Title Bottom", example = "Our philosophy")
  private String titleBottom;
  @Schema(description = "Ddescrption Bottom", example = "Der Verein setzt sich für...")
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

  public static List<AboutUsDto> transformAboutUsToAboutUsDto(List<AboutUs> aboutUs) {

    return aboutUs
        .stream().map(AboutUsDto::transformAboutUsToAboutUsDto)
        .collect(Collectors.toList());
  }
}
