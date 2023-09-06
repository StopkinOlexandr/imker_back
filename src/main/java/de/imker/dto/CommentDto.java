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
@Schema(description = "One comment data")
public class CommentDto {
  @Schema(description = "Comment ID in DB", example = "1")
  private Long id;

  @Schema(description = "Time of comment creation", example = "yyyy-MM-dd HH:mm:ss")
  private String creationTime;

  @Schema(description = "Text of comment", example = "This is a comment.")
  private String commentText;
  @Schema(description = "Author id", example = "1")
  private Long userId;
  @Schema(description = "Author name", example = "Joe Dow")
  private String userName;
  @Schema(description = "Author logo", example = "1")
  private String userLogo;

}
