package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
  private Long idPost;
  private Long idUser;
  private String creationTimePost;
  private String titleTextPost;
  private String imgLinkPost;
  private String textOfPost;
}
