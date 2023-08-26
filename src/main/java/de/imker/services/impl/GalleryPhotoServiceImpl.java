package de.imker.services.impl;

import de.imker.dto.FileUploadDto;
import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.FileUpload;
import de.imker.models.GalleryPhoto;
import de.imker.repositories.FilesRepository;
import de.imker.repositories.GalleryPhotoRepository;
import de.imker.services.GalleryPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static de.imker.utils.UtilsMethods.getPageRequest;

@RequiredArgsConstructor
@Transactional
@Service
public class GalleryPhotoServiceImpl implements GalleryPhotoService {
  private final GalleryPhotoRepository galleryPhotoRepository;
  private final FilesRepository filesRepository;

  @Value("${files.upload.path}")
  private String uploadPath;

  @Override
  public GalleryPhotoDto addPhoto(NewGalleryPhotoDto newGalleryPhotoDto) {
    GalleryPhoto galleryPhoto = GalleryPhoto.builder()
        .linkToImg(newGalleryPhotoDto.getLinkToImg())
        .build();

    galleryPhotoRepository.save(galleryPhoto);

    return GalleryPhotoDto.from(galleryPhoto);
  }

  @Override
  public GalleryPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk) {
    Page<GalleryPhoto> pageOfPhotos;

    PageRequest pageRequest = getPageRequest(page, items, orderBy, desk);

    pageOfPhotos = galleryPhotoRepository.findAll(pageRequest);

    return GalleryPhotosDto.builder()
        .photos(GalleryPhotoDto.from(pageOfPhotos.getContent()))
        .count((int) pageOfPhotos.getTotalElements())
        .pages(pageOfPhotos.getTotalPages())
        .build();
  }

  @Override
  public GalleryPhotoDto deletePhotoById(Long photoId) {
    GalleryPhoto galleryPhoto = (GalleryPhoto) galleryPhotoRepository.getGalleryPhotoById(photoId).orElseThrow(
        () -> new NotFoundException("Gallery photo with id <" + photoId + "> not found"));

    FileUpload fileUpload = filesRepository.getFileById(galleryPhoto.getLinkToImg()).orElseThrow(
        () -> new NotFoundException("File with id <" + galleryPhoto.getLinkToImg() + "> not found"));

    Path filePath = Paths.get(uploadPath, fileUpload.getStoredName());

    try {
      Files.delete(filePath);
      filesRepository.delete(fileUpload);
      galleryPhotoRepository.delete(galleryPhoto);
    } catch (IOException e) {
      throw new NotFoundException("File not found");
    }
    return GalleryPhotoDto.from(galleryPhoto);
  }

}
