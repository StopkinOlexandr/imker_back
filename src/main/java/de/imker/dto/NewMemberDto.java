package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Schema(description = "New Team Member")
@Builder
public class NewMemberDto {

  @Schema(description = "Visible members on page AboutUs: SHOW, HIDDEN", example = "SHOW")
  private String state;
  @Schema(description = "Members Name", example = "First Name and Last Name ")
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
  @Email
  private String email;
  @Schema(description = "Facebook", example = "https://www.facebook.com/FacebookId")
  private String facebook;
  @Schema(description = "Instagram", example = "https://www.instagram.com/InstagramId")
  private String instagram;
}
