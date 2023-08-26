package de.imker.services.impl;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.models.GalleryPhoto;
import de.imker.repositories.GalleryPhotoRepository;
import de.imker.services.GalleryPhotoService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.imker.utils.UtilsMethods.getPageRequest;

@RequiredArgsConstructor
@Transactional
@Service
public class GalleryPhotoServiceImpl implements GalleryPhotoService {
  private final GalleryPhotoRepository galleryPhotoRepository;

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

}
