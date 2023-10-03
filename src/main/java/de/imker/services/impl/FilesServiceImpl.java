package de.imker.services.impl;

import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.FileUpload;
import de.imker.repositories.FilesRepository;
import de.imker.services.FilesService;
import de.imker.utils.FileStorageService;
import de.imker.utils.FileUploadSpecifications;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FilesServiceImpl implements FilesService {

  private final FilesRepository filesRepository;
  private final FileStorageService fileStorageService;

  @Value("${files.upload.path}")
  private String uploadPath;

  @Value("${aws.s3.endpointUrl}")
  private String awsS3EndpointUrl;

  @Override
  public File convertToFile(MultipartFile multipartFile) throws IOException {
    File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
    try {
      Path filePath = file.toPath();
      Files.copy(multipartFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new IOException("Failed to convert MultipartFile to File", e);
    }
    return file;
  }

  @Override
  public File resizeImage(File sourceImage, int width, int height, String targetDirectory) {
    File targetImage = new File(targetDirectory, "resized_" + sourceImage.getName());
    try {
      Thumbnails.of(sourceImage)
          .size(width, height)
          .toFile(targetImage);
    } catch (IOException e) {
      return sourceImage;
    }
    return targetImage;
  }

  @Override
  public FileUploadDto uploadFile(MultipartFile file, Integer width, Integer height, String category) throws IOException {
    String originalName = file.getOriginalFilename();
//    String storedName = UUID.randomUUID() + originalName;

    File sourceFile = convertToFile(file);
    File resizedFile = resizeImage(sourceFile, width, height, uploadPath);

    byte[] resizedFileBytes = Files.readAllBytes(resizedFile.toPath());

//    Files.write(Paths.get(uploadPath + storedName), resizedFileBytes);

    if (!EnumUtils.isValidEnum(FileUpload.Category.class, category)) {
      category = "NONE";
    }

    FileUpload fileUpload = FileUpload.builder()
        .category(FileUpload.Category.valueOf(category))
        .originalName(originalName)
        .storedName("tmp")
        .fileType(file.getContentType())
        .size((long) resizedFileBytes.length)
        .build();

    filesRepository.save(fileUpload);
    fileUpload.setStoredName(fileUpload.getId().toString());
    filesRepository.save(fileUpload);

    fileStorageService.uploadFile(fileUpload.getStoredName(), resizedFile);


    // Ignore the results of delete since it's a temporary file
    sourceFile.delete();
    resizedFile.delete();

    return FileUploadDto.from(fileUpload);
  }

  @Override
  public FileUploadDto getFileInfoById(Long fileId) {
    FileUpload fileUpload = filesRepository.getFileById(fileId).orElseThrow(
        () -> new NotFoundException("File with id <" + fileId + "> not found"));

    return FileUploadDto.from(fileUpload);
  }

  @Override
  public Resource getFileResource(Long fileId) {
    FileUploadDto fileUploadDto = getFileInfoById(fileId);
//    File file = new File(uploadPath, fileUploadDto.getStoredName());

    try {
      File file = fileStorageService.getFileFromSpaces(fileUploadDto.getStoredName());
      byte[] fileContent = Files.readAllBytes(file.toPath());
      return new ByteArrayResource(fileContent);
    } catch (IOException e) {
      throw new NotFoundException("File with id <" + fileId + "> not found");
    }
  }

  @Override
  public FilesListDto getAllFiles(Integer page, Integer items, String filter) {

    PageRequest pageRequest;
    Page<FileUpload> pageOfFiles;

    pageRequest = PageRequest.of(page, items, Sort.by(Sort.Direction.DESC, "id"));

    if (filter == null) {
      filter = "ALL";
    }

    Specification<FileUpload> spec = Specification
        .where(FileUploadSpecifications.fileFilter(filter));

    pageOfFiles = filesRepository.findAll(spec, pageRequest);

    return FilesListDto.builder()
        .files(FileUploadDto.from(pageOfFiles.getContent()))
        .count((int) pageOfFiles.getTotalElements())
        .pages(pageOfFiles.getTotalPages())
        .build();
  }

  @Override
  public FileUploadDto deleteFileById(Long fileId) {

    fileStorageService.deleteFileFromSpaces(fileId.toString());

    Optional<FileUpload> fileUploadTemp = filesRepository.getFileById(fileId);
    if (fileUploadTemp.isPresent()) {

      FileUpload fileUpload = fileUploadTemp.get();

//      Path filePath = Paths.get(uploadPath, fileUpload.getStoredName());
//
//      if (Files.exists(filePath)) {
//        try {
//          Files.delete(filePath);
//        } catch (IOException e) {
//          throw new NotFoundException("Failed to delete file: " + e.getMessage());
//        }
//      }

      filesRepository.delete(fileUpload);
      return FileUploadDto.from(fileUpload);
    }


    return FileUploadDto.builder()
        .storedName("File not found")
        .build();
  }

}
