package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "New Team Member")
public class NewMemberDto {

  @Schema(description = "Members Name", example = "Mart Tven")
  private String name;
  private String position;
  private String description;
  private String image;
  private String phone;
  private String email;
  private String facebook;
  private String instagram;
}
