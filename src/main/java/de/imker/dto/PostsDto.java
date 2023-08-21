package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "List of posts")
public class PostsDto {
  @Schema(description = "List of posts")
  private List<PostDto> posts;

  @Schema(description = "Total amount of posts", example = "1")
  private Integer count;

  @Schema(description = "Number of pages", example = "1")
  private Integer pages;
}
