package de.imker.services.impl;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.FileUpload;
import de.imker.models.GalleryPhoto;
import de.imker.repositories.FilesRepository;
import de.imker.repositories.GalleryPhotoRepository;
import de.imker.services.GalleryPhotoService;
import de.imker.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static de.imker.utils.UtilsMethods.getPageRequest;

@RequiredArgsConstructor
@Transactional
@Service
public class GalleryPhotoServiceImpl implements GalleryPhotoService {
  private final GalleryPhotoRepository galleryPhotoRepository;
  private final FilesRepository filesRepository;
  private final FileStorageService fileStorageService;


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

    GalleryPhoto galleryPhoto = null;

    Optional<GalleryPhoto> optionalGalleryPhoto = galleryPhotoRepository.getGalleryPhotoById(photoId);
    if (optionalGalleryPhoto.isPresent()) {
      galleryPhoto = optionalGalleryPhoto.get();
      Long linkToImg = galleryPhoto.getLinkToImg();
      galleryPhotoRepository.delete(galleryPhoto);

      Optional<FileUpload> optionalFileUpload = filesRepository.getFileById(linkToImg);
      if (optionalFileUpload.isPresent()) {
        FileUpload fileUpload = optionalFileUpload.get();

        fileStorageService.deleteFileFromSpaces(fileUpload.getStoredName());
        filesRepository.delete(fileUpload);
      } else {
        System.out.println("file not found");
      }
    } else {
      throw new NotFoundException("Gallery photo with id <" + photoId + "> not found");
    }


//    GalleryPhoto galleryPhoto = (GalleryPhoto) galleryPhotoRepository.getGalleryPhotoById(photoId).orElseThrow(
//        () -> new NotFoundException("Gallery photo with id <" + photoId + "> not found"));
//
//    FileUpload fileUpload = filesRepository.getFileById(galleryPhoto.getLinkToImg()).orElseThrow(
//        () -> new NotFoundException("File with id <" + galleryPhoto.getLinkToImg() + "> not found"));
//
//
//    fileStorageService.deleteFileFromSpaces(fileUpload.getStoredName());
//    galleryPhotoRepository.delete(galleryPhoto);
//    filesRepository.delete(fileUpload);

//    Path filePath = Paths.get(uploadPath, fileUpload.getStoredName());
//
//    try {
//      Files.delete(filePath);
//      filesRepository.delete(fileUpload);
//      galleryPhotoRepository.delete(galleryPhoto);
//    } catch (IOException e) {
//      throw new NotFoundException("File not found");
//    }
    assert galleryPhoto != null;
    return GalleryPhotoDto.from(galleryPhoto);
  }

}
