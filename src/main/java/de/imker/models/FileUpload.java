package de.imker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "files")
public class FileUpload {
  public enum Category {
    NONE,
    POST,
    EVENT,
    GALLERY,
    AVATAR,
    SLIDER
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation_time")
  private Date creationTime;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private FileUpload.Category category;

  @Column(nullable = false)
  private String originalName;

  @Column(nullable = false)
  private String storedName;

  @Column(nullable = false)
  private String fileType;

  @Column(nullable = false)
  private Long size;
}
