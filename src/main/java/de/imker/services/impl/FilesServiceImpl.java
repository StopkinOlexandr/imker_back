package de.imker.services.impl;

import de.imker.dto.FileUploadDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.FileUpload;
import de.imker.repositories.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl {

  @Autowired
  private final FilesRepository filesRepository;

  @Value("${files.upload.path}")
  private String uploadPath;

  public FileUploadDto uploadFile(MultipartFile file) throws IOException {
    String originalName = file.getOriginalFilename();
    String storedName = UUID.randomUUID() + originalName;

    FileUpload fileUpload = FileUpload.builder()
        .originalName(originalName)
        .storedName(storedName)
        .fileType(file.getContentType())
        .size(file.getSize())
        .build();

    Files.write(Paths.get(uploadPath + storedName), file.getBytes());
    filesRepository.save(fileUpload);


    return FileUploadDto.builder()
        .id(fileUpload.getId())
        .creationTime(fileUpload.getCreationTime())
        .originalName(fileUpload.getOriginalName())
        .storedName(fileUpload.getStoredName())
        .fileType(fileUpload.getFileType())
        .size(fileUpload.getSize())
        .build();
  }

  public FileUploadDto getFile(Long fileId) {
    FileUpload fileUpload = filesRepository.getFileById(fileId).orElseThrow(
        () -> new NotFoundException("File with id <" + fileId + "> not found"));
    File file = new File(uploadPath, fileUpload.getStoredName());

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

  public Resource getFileResource(Long fileId) {
    FileUploadDto fileUploadDto = getFile(fileId);

    if (fileUploadDto != null && fileUploadDto.getFile() != null) {
      try {
        byte[] fileContent = Files.readAllBytes(fileUploadDto.getFile().toPath());
        return new ByteArrayResource(fileContent);
      } catch (IOException e) {
        throw new NotFoundException("File with id <" + fileId + "> not found");
      }
    }

    return null;
  }

}
