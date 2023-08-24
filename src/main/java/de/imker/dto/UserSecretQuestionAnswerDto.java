package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "New password from user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserSecretQuestionAnswerDto {
  @Schema(description = "User's id", example = "1")
  private Long id;

  @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
  private String email;

  @Schema(description = "Secret question", example = "First Auto?")
  private String secretQuestion;

  @Schema(description = "Secret question answer", example = "Ford")
  private String secretQuestionAnswer;
}
