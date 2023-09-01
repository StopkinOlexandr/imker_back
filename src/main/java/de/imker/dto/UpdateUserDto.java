package de.imker.dto;

import de.imker.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateUserDto {


  @Schema(description = "User's name", example = "Alex Krause")
  private String name;

  @Schema(description = "User's PLZ", example = "01234")
  private String plz;

  @Schema(description = "User's phone", example = "0123456789")
  private String phone;

  @Schema(description = "User's image", example = "???") //TODO
  private String image;

  @Schema(description = "Users status - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
  private String state;

  @Schema(description = "User's role: ADMIN, MEMBER, USER", example = "USER")
  private String role;

}
