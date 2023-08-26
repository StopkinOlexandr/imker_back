package de.imker.controllers;

import de.imker.controllers.api.GalleryApi;
import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.NewGalleryPhotoDto;
import de.imker.services.GalleryPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GalleryController implements GalleryApi {
  private final GalleryPhotoService galleryPhotoService;
  @Override
  public GalleryPhotoDto addPhoto(NewGalleryPhotoDto newGalleryPhotoDto) {
    return galleryPhotoService.addPhoto(newGalleryPhotoDto);
  }
}
