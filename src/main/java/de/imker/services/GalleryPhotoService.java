package de.imker.services;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;

public interface GalleryPhotoService {

  GalleryPhotoDto addPhoto(NewGalleryPhotoDto newGalleryPhotoDto);

  GalleryPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk);

  GalleryPhotoDto deletePhotoById(Long photoId);

}
