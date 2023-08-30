package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateMemberDto {

  @Schema(description = "Visible members on page AboutUs: SHOW, HIDDEN", example = "SHOW")
  private String state;
  @Schema(description = "Members Name", example = "Mart Tven")
  private String name;
  @Schema(description = "Member's position", example = "")
  private String position;
  @Schema(description = "Description of member", example = "")
  private String description;
  @Schema(description = "Photo", example = "3")
  private String image;
  @Schema(description = "Phone", example = "+49 1234 5678912")
  private String phone;
  @Schema(description = "E-mail", example = "imker@gmail.com")
  private String email;
  @Schema(description = "Facebook", example = "https://www.facebook.com/FacebookId")
  private String facebook;
  @Schema(description = "Instagram", example = "https://www.instagram.com/InstagramId")
  private String instagram;
}
