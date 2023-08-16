package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Uploaded file info")
public class FileUploadDto {

  private Long id;
  private Date creationTime;
  private String originalName;
  private String storedName;
  private String fileType;
  private Long size;


}
