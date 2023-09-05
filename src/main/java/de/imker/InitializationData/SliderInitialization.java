package de.imker.InitializationData;

import de.imker.models.SliderPhoto;
import de.imker.repositories.SliderPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SliderInitialization {

  @Autowired
  private final SliderPhotoRepository sliderPhotoRepository;

  public void galleryInit() {
    List<SliderPhoto> sliderPhotoList = sliderPhotoRepository.findAll();

    if (sliderPhotoList.size() == 0) {
      SliderPhoto sliderPhoto = SliderPhoto.builder()
          .linkToImg(21L)
          .build();
      sliderPhotoRepository.save(sliderPhoto);

      for (long i = 22; i < 26; i++) {

        sliderPhoto = SliderPhoto.builder()
            .linkToImg(i)
            .build();

        sliderPhotoRepository.save(sliderPhoto);
      }
    }
  }
}
