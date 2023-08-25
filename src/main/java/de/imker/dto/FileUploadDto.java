package de.imker.dto;

import de.imker.models.FileUpload;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Uploaded file info")
public class FileUploadDto {

  @Schema(description = "File ID in DB", example = "1")
  private Long id;
  @Schema(description = "Time of file loading", example = "yyyy-MM-dd HH:mm:ss")
  private Date creationTime;
  @Schema(description = "Category of file: POST, EVENT, GALLERY, AVATAR", example = "GALLERY")
  private String category;
  @Schema(description = "Original file name", example = "example.jpg")
  private String originalName;
  @Schema(description = "Stored file name", example = "UUID+example.jpg")
  private String storedName;
  @Schema(description = "Stored file type", example = "image/jpeg")
  private String fileType;
  @Schema(description = "Stored file size in Bytes", example = "1234")
  private Long size;

  public static FileUploadDto from(FileUpload fileUpload) {
    return FileUploadDto.builder()
        .id(fileUpload.getId())
        .creationTime(fileUpload.getCreationTime())
        .category(fileUpload.getCategory().name())
        .originalName(fileUpload.getOriginalName())
        .storedName(fileUpload.getStoredName())
        .fileType(fileUpload.getFileType())
        .size(fileUpload.getSize())
        .build();
  }

  public static List<FileUploadDto> from(List<FileUpload> files) {
    return files.stream()
        .map(FileUploadDto::from)
        .collect(Collectors.toList());
  }

}
