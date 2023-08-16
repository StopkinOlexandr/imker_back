package de.imker.controllers;

import de.imker.services.impl.FilesServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FilesController {

  @Value("${files.upload.path}")
  private String uploadPath;

  @Autowired
  private FilesServiceImpl filesService;

  @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String uploadFile(@NotNull @RequestParam("file")MultipartFile file) throws IOException {

    return filesService.uploadFile(file);
  }
}
