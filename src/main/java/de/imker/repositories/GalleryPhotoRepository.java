package de.imker.repositories;

import de.imker.models.GalleryPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryPhotoRepository extends JpaRepository<GalleryPhoto, Long> {
}
