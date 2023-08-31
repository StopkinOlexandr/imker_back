package de.imker.dto;

import de.imker.models.Event;
import de.imker.models.User.Role;
import de.imker.models.User.State;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateUserDto {


  @Schema(description = "User's name", example = "Alex Krause")
  private String newName;

  @Schema(description = "User's PLZ", example = "01234")
  private String newPlz;

  @Schema(description = "User's phone", example = "0123456789")
  private String newPhone;

  @Schema(description = "User's image", example = "???") //TODO
  private String newImage;

  @Schema(description = "Users status - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
  private String newState;

  @Schema(description = "User's role: ADMIN, MEMBER, USER", example = "USER")
  private String newRole;

  @Schema(description = "User's events list")
  private List<Event> newEvents;
}
