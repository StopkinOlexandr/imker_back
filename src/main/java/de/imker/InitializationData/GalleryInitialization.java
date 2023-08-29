package de.imker.InitializationData;

import de.imker.models.GalleryPhoto;
import de.imker.repositories.GalleryPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GalleryInitialization {

  @Autowired
  private final GalleryPhotoRepository galleryPhotoRepository;

  public void galleryInit(){

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

//    galleryPhoto = GalleryPhoto.builder()
//        .linkToImg(122L)
//        .build();
//    galleryPhotoRepository.save(galleryPhoto);
//
//    galleryPhoto = GalleryPhoto.builder()
//        .linkToImg(123L)
//        .build();
//    galleryPhotoRepository.save(galleryPhoto);
//
//    galleryPhoto = GalleryPhoto.builder()
//        .linkToImg(124L)
//        .build();
//    galleryPhotoRepository.save(galleryPhoto);
  }
}
