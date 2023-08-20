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
  @Schema(description = "Link to title image", example = "https://media.licdn.com/dms/image/D5612AQEbJ4rWMni4sg/article-cover_image-shrink_600_2000/0/1668510691763?e=2147483647&v=beta&t=BWQ7qKriObtTgft2YZa25YvzIeAhBfdF0xDXq09G9oE")
  private String linkToImg;
  @Schema(description = "short description for post text", example = "Short description")
  private String shortPostDescription;
  @Schema(description = "new post text", example = "<p>HTML text</p>")
  private String textOfPost;
  @Schema(description = "author name", example = "Jack Daniel")
  private String authorName;
}
