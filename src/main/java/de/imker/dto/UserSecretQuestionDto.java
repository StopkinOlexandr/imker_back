package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "New password from user")
@Data
public class UserSecretQuestionDto {

  @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
  private String email;

  @Schema(description = "Answer for secret question", example = "Dog")
  private String secretQuestion;
}


