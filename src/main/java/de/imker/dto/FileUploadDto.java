package de.imker.dto;

import de.imker.models.FileUpload;
import de.imker.models.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
  private File file;

  public static FileUploadDto from(FileUpload fileUpload, File file){
    return FileUploadDto.builder()
        .id(fileUpload.getId())
        .creationTime(fileUpload.getCreationTime())
        .originalName(fileUpload.getOriginalName())
        .storedName(fileUpload.getStoredName())
        .fileType(fileUpload.getFileType())
        .size(fileUpload.getSize())
        .file(file)
        .build();
  }

  public static FileUploadDto from(FileUpload fileUpload){
    return FileUploadDto.builder()
        .id(fileUpload.getId())
        .creationTime(fileUpload.getCreationTime())
        .originalName(fileUpload.getOriginalName())
        .storedName(fileUpload.getStoredName())
        .fileType(fileUpload.getFileType())
        .size(fileUpload.getSize())
        .build();
  }

  public static List<FileUploadDto> from(List<FileUpload> files ){
    return files.stream()
        .map(FileUploadDto::from)
        .collect(Collectors.toList());
  }

}
