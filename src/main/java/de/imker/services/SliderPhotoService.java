package de.imker.services;

import de.imker.dto.SliderPhotoDto;
import de.imker.dto.SliderPhotosDto;
import de.imker.dto.NewSliderPhotoDto;

public interface SliderPhotoService {

  SliderPhotoDto addPhoto(NewSliderPhotoDto newSliderPhotoDto);

  SliderPhotosDto getAllPhotos(Integer page, Integer items, String orderBy, Boolean desk);

  SliderPhotoDto deletePhotoById(Long photoId);

}
