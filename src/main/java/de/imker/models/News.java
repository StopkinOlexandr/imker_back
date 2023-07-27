package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {
  private Long idNews;
  private String creationTimeNews;
  private String titleTextNews;
  private String linkToImageNews;
  private String textOfNews;

}
