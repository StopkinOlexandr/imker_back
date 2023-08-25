package de.imker.dto;

import de.imker.models.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data of the created post")
public class PostDto {
  @Schema(description = "Post ID in DB", example = "1")
  private Long idPost;
  @Schema(description = "Time of post creation", example = "yyyy-MM-dd HH:mm:ss")
  private String creationTimePost;
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

  public static PostDto from(Post post){
    return PostDto.builder()
        .idPost(post.getId())
        .creationTimePost(dateToString(post.getCreationTimePost()))
        .titlePost(post.getTitlePost())
        .linkToImg(post.getLinkToImg())
        .shortPostDescription(post.getShortPostDescription())
        .textOfPost(post.getTextOfPost())
        .authorName(post.getAuthorName())
        .build();
  }

  public static List<PostDto> from(List<Post> posts){
    return posts.stream()
        .map(PostDto::from)
        .collect(Collectors.toList());
  }

  public static String dateToString(Date date){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormat.format(date);
  }


}
