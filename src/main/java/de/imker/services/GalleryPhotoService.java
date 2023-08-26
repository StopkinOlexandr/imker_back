package de.imker.services;

import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.NewGalleryPhotoDto;

public interface GalleryPhotoService {

  GalleryPhotoDto addPhoto(NewGalleryPhotoDto newGalleryPhotoDto);

}
