package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "New comment data")
public class NewCommentDto {

  @Schema(description = "Text of comment", example = "This is a comment.")
  private String commentText;
  @Schema(description = "Author id", example = "1")
  private Long userId;
  @Schema(description = "Event id", example = "1")
  private Long eventId;
  @Schema(description = "Post id", example = "1")
  private Long postId;
}
