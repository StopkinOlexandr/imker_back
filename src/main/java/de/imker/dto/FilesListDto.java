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
@Schema(description = "List of files")
public class FilesListDto {
  @Schema(description = "List of files")
  private List<FileUploadDto> files;

  @Schema(description = "Total amount of files", example = "1")
  private Integer count;

  @Schema(description = "Number of pages", example = "1")
  private Integer pages;
}
