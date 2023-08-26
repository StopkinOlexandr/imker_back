package de.imker.services.impl;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.models.GalleryPhoto;
import de.imker.repositories.GalleryPhotoRepository;
import de.imker.services.GalleryPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

  @Override
  public GalleryPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk) {
    PageRequest pageRequest;
    Page<GalleryPhoto> pageOfPhotos;

    if (orderBy != null && !orderBy.equals("")) {
      Sort.Direction direction = Sort.Direction.ASC;

      if (desk != null && desk) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderBy);
      pageRequest = PageRequest.of(page, items, sort);
    } else {
      pageRequest = PageRequest.of(page, items, Sort.by(Sort.Direction.ASC, "id"));
    }

    pageOfPhotos = galleryPhotoRepository.findAll(pageRequest);

    return GalleryPhotosDto.builder()
        .photos(GalleryPhotoDto.from(pageOfPhotos.getContent()))
        .count((int) pageOfPhotos.getTotalElements())
        .pages(pageOfPhotos.getTotalPages())
        .build();
  }
}
