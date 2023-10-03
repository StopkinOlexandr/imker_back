package de.imker.repositories;

import de.imker.models.GalleryPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GalleryPhotoRepository extends JpaRepository<GalleryPhoto, Long> {
  Optional<GalleryPhoto> getGalleryPhotoById(Long photoId);

}
