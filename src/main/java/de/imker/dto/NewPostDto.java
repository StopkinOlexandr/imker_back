package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data for creating a new post")
public class NewPostDto {
  @Schema(description = "new post title", example = "Title of the post")
  private String titlePost;
  @Schema(description = "Id of title image file in DB", example = "1")
  private String linkToImg;
  @Schema(description = "short description for post text", example = "Short description")
  private String shortPostDescription;
  @Schema(description = "new post text", example = "<p>HTML text</p>")
  private String textOfPost;
  @Schema(description = "author name", example = "Jack Daniel")
  private String authorName;
}
