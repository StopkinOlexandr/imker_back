package de.imker.models;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="aboutus")
public class AboutUs {
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
