package de.imker.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="aboutus")
public class AboutUs {

  @Schema(description = "Identification", example = "1")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String titleTop;
  private String descriptionTop;
  private String titleBottom;
  private String descriptionBottom;
  private String image1;
  private String image2;
}
