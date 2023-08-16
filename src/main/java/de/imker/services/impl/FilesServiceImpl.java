package de.imker.services.impl;

import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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


    return FileUploadDto.from(fileUpload);
  }

  public FileUploadDto getFileById(Long fileId) {
    FileUpload fileUpload = filesRepository.getFileById(fileId).orElseThrow(
        () -> new NotFoundException("File with id <" + fileId + "> not found"));

    File file = new File(uploadPath, fileUpload.getStoredName());

    return FileUploadDto.from(fileUpload, file);
  }

  public Resource getFileResource(Long fileId) {
    FileUploadDto fileUploadDto = getFileById(fileId);

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

  public FilesListDto getAllFiles() {
    List<FileUpload> files = filesRepository.findAll();

    return new FilesListDto(FileUploadDto.from(files),files.size());
  }

  public FileUploadDto deleteFileById(Long fileId) {
    FileUpload fileUpload = filesRepository.getFileById(fileId).orElseThrow(
        () -> new NotFoundException("File with id <" + fileId + "> not found"));

    Path filePath = Paths.get(uploadPath, fileUpload.getStoredName()); // Путь к файлу

    try {
      Files.delete(filePath);
      filesRepository.delete(fileUpload);
    } catch (IOException e) {
      throw new NotFoundException("File not found");
    }
    return FileUploadDto.from(fileUpload);
  }
}
