package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "New password from user")
@Data
public class UserRestorePwd {
  @Schema(description = "User's new password", example = "#123abcABC")
  private String newPassword;
}
