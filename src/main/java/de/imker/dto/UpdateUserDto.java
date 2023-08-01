package de.imker.dto;

import de.imker.models.User.Role;
import de.imker.models.User.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateUserDto {

  @Schema(description = "Users status - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")

  private String newName;
  private String newPlz;
  private String newPhone;
  private String newImage;
  private String newState;
  private String newRole;

}
