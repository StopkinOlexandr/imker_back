package de.imker.repositories;

import de.imker.models.SliderPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SliderPhotoRepository extends JpaRepository<SliderPhoto, Long> {
  Optional<Object> getSliderPhotoById(Long photoId);

}
