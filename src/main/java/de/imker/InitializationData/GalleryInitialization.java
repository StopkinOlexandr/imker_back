package de.imker.InitializationData;

import de.imker.models.GalleryPhoto;
import de.imker.repositories.GalleryPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GalleryInitialization {

  @Autowired
  private final GalleryPhotoRepository galleryPhotoRepository;

  public void galleryInit() {
    List<GalleryPhoto> galleryPhotoList = galleryPhotoRepository.findAll();

    if (galleryPhotoList.size() == 0) {
      GalleryPhoto galleryPhoto = GalleryPhoto.builder()
          .linkToImg(121L)
          .build();
      galleryPhotoRepository.save(galleryPhoto);

      for (long i = 122; i < 145; i++) {

        galleryPhoto = GalleryPhoto.builder()
            .linkToImg(i)
            .build();

        galleryPhotoRepository.save(galleryPhoto);
      }
    }
  }
}
