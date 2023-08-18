package de.imker.controllers;

import de.imker.controllers.api.FilesApi;
import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
import de.imker.services.FilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class FilesController implements FilesApi {

  private final FilesService filesService;

  @Override
  public FileUploadDto uploadFile(MultipartFile file, Integer width, Integer height) throws IOException {

    return filesService.uploadFile(file, width, height);
  }

  @Override
  public ResponseEntity<Resource> getFileById(Long fileId) {

    Resource resource = filesService.getFileResource(fileId);

    if (resource != null) {
      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<FileUploadDto> getFileInfoById(Long fileId) {
    return ResponseEntity.ok(filesService.getFileInfoById(fileId));
  }

  @Override
  public FilesListDto getAllFiles() {
    return filesService.getAllFiles();
  }

  @Override
  public FileUploadDto deleteFileById(Long fileId) {
    return filesService.deleteFileById(fileId);
  }
}
