package de.imker.controllers;

import de.imker.controllers.api.SliderApi;
import de.imker.dto.NewSliderPhotoDto;
import de.imker.dto.SliderPhotoDto;
import de.imker.dto.SliderPhotosDto;
import de.imker.services.SliderPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SliderController implements SliderApi {
  private final SliderPhotoService sliderPhotoService;

  @Override
  public SliderPhotoDto addPhoto(NewSliderPhotoDto newSliderPhotoDto) {
    return sliderPhotoService.addPhoto(newSliderPhotoDto);
  }

  @Override
  public SliderPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk) {
    return sliderPhotoService.getAllPhotos(page, items, orderBy, desk);
  }

  @Override
  public SliderPhotoDto deletePhotoById(Long photoId) {
    return sliderPhotoService.deletePhotoById(photoId);
  }
}
