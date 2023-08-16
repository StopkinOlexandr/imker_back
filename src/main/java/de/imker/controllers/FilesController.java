package de.imker.controllers;

import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
import de.imker.services.impl.FilesServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FilesController {

  @Value("${files.upload.path}")
  private String uploadPath;

  @Autowired
  private FilesServiceImpl filesService;

  @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public FileUploadDto uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

    return filesService.uploadFile(file);
  }

  @GetMapping(path = "/{file-id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Resource> getFileById(@Parameter(required = true, description = "File ID", example = "1")
                                          @PathVariable("file-id") Long fileId) {

    Resource resource = filesService.getFileResource(fileId);

    if (resource != null) {
      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public FilesListDto getAllFiles(){
    return filesService.getAllFiles();
  }

  @DeleteMapping(path = "/delete/{file-id}")
  public FileUploadDto deleteFileById(@Parameter(required = true, description = "File ID", example = "1")
                                    @PathVariable("file-id") Long fileId){
    return filesService.deleteFileById(fileId);
  }
}
