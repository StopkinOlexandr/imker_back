package de.imker.services.impl;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.models.GalleryPhoto;
import de.imker.repositories.GalleryPhotoRepository;
import de.imker.services.GalleryPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
