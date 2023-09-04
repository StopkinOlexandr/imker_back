package de.imker.services;

import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FilesService {
  File convertToFile(MultipartFile multipartFile) throws IOException;

  File resizeImage(File sourceImage, int width, int height, String targetDirectory);

  FileUploadDto uploadFile(MultipartFile file, Integer width, Integer height, String category) throws IOException;

  FileUploadDto getFileInfoById(Long fileId);

  Resource getFileResource(Long fileId);

  FilesListDto getAllFiles(Integer page, Integer items, String filter);

  FileUploadDto deleteFileById(Long fileId);
}
