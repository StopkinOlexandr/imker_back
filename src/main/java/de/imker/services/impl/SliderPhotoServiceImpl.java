package de.imker.services.impl;

import de.imker.dto.SliderPhotoDto;
import de.imker.dto.SliderPhotosDto;
import de.imker.dto.NewSliderPhotoDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.FileUpload;
import de.imker.models.SliderPhoto;
import de.imker.repositories.FilesRepository;
import de.imker.repositories.SliderPhotoRepository;
import de.imker.services.SliderPhotoService;
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
public class SliderPhotoServiceImpl implements SliderPhotoService {
  private final SliderPhotoRepository sliderPhotoRepository;
//  private final FilesRepository filesRepository;
private final FilesServiceImpl filesService;

  @Value("${files.upload.path}")
  private String uploadPath;

  @Override
  public SliderPhotoDto addPhoto(NewSliderPhotoDto newSliderPhotoDto) {
    SliderPhoto galleryPhoto = SliderPhoto.builder()
        .linkToImg(newSliderPhotoDto.getLinkToImg())
        .build();

    sliderPhotoRepository.save(galleryPhoto);

    return SliderPhotoDto.from(galleryPhoto);
  }

  @Override
  public SliderPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk) {
    Page<SliderPhoto> pageOfPhotos;

    PageRequest pageRequest = getPageRequest(page, items, orderBy, desk);

    pageOfPhotos = sliderPhotoRepository.findAll(pageRequest);

    return SliderPhotosDto.builder()
        .photos(SliderPhotoDto.from(pageOfPhotos.getContent()))
        .count((int) pageOfPhotos.getTotalElements())
        .pages(pageOfPhotos.getTotalPages())
        .build();
  }

  @Override
  public SliderPhotoDto deletePhotoById(Long photoId) {
    SliderPhoto galleryPhoto = (SliderPhoto) sliderPhotoRepository.getSliderPhotoById(photoId).orElseThrow(
        () -> new NotFoundException("Slider photo with id <" + photoId + "> not found"));
    filesService.deleteFileById(galleryPhoto.getLinkToImg());
    sliderPhotoRepository.delete(galleryPhoto);

//    FileUpload fileUpload = filesRepository.getFileById(galleryPhoto.getLinkToImg()).orElseThrow(
//        () -> new NotFoundException("File with id <" + galleryPhoto.getLinkToImg() + "> not found"));
//
//    Path filePath = Paths.get(uploadPath, fileUpload.getStoredName());

//    try {
//      Files.delete(filePath);
//      filesRepository.delete(fileUpload);
//    } catch (IOException e) {
//      throw new NotFoundException("File not found");
//    }

    return SliderPhotoDto.from(galleryPhoto);
  }

}
