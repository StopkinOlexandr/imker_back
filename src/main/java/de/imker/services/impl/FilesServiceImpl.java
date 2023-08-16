package de.imker.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl {

  @Value("${files.upload.path}")
  private String uploadPath;

  public String uploadFile(MultipartFile file) throws IOException {
    Files.write(Paths.get(uploadPath+"upload.jpg"), file.getBytes());


    return "file name <"+file.getOriginalFilename()+"> file type <"+file.getContentType()+"> file size <"+file.getSize()+">";
  }
}
