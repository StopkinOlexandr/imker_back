package de.imker.InitializationData;

import de.imker.models.FileUpload;
import de.imker.repositories.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FilesInitialization {

  @Autowired
  private final FilesRepository filesRepository;


  public void filesInit() {
    List<FileUpload> filesList = filesRepository.findAll();
    if (filesList.size() == 0) {
      for (int i = 0; i < 50; i++) {
        FileUpload fileUpload = FileUpload.builder()
            .originalName("empty -")
            .storedName("empty -")
            .fileType("empty -")
            .size((long) 10)
            .build();
        filesRepository.save(fileUpload);
      }


      FileUpload fileUpload = FileUpload.builder()
          .id(1L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("kopfbild_vereine_03[1].jpg")
          .storedName("!1-7f1bb7eb-231b-4535-b917-ca7819841540kopfbild_vereine_03[1].jpg")
          .fileType("image/jpeg")
          .size((long) 33632)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(2L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("header-ratgeber-bienen[1].jpg")
          .storedName("!2-b3d40dd7-5813-4ecc-b1fc-188e685061ddheader-ratgeber-bienen[1].jpg")
          .fileType("image/jpeg")
          .size((long) 27381)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(3L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("5376145_original2560_1zX9HW_qP3j6P[1].jpg")
          .storedName("!3-871d3f92-bff9-4333-a0bd-62e63d3d37845376145_original2560_1zX9HW_qP3j6P[1].jpg")
          .fileType("image/jpeg")
          .size((long) 21111)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(4L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("honigbienen-01[1].jpg")
          .storedName("!4-707c4d7c-6fc7-4f8f-92b8-c287f1520442honigbienen-01[1].jpg")
          .fileType("image/jpeg")
          .size((long) 75514)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(5L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("w940_h528_x470_y264_5736869295a8f6e7[1].jpg")
          .storedName("!5-6ed43282-1516-4578-ba2c-1327982b4365w940_h528_x470_y264_5736869295a8f6e7[1].jpg")
          .fileType("image/jpeg")
          .size((long) 32690)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(6L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("Honigvielfalt[1].jpg")
          .storedName("!6-01c11f85-b8b9-46df-99c1-51cd7b456099Honigvielfalt[1].jpg")
          .fileType("image/jpeg")
          .size((long) 41939)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(7L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("Honigglaeser_980_rdax_720x316_80[1].jpg")
          .storedName("!7-ec0b4ac4-73de-4251-8a11-ef387c42c8a8Honigglaeser_980_rdax_720x316_80[1].jpg")
          .fileType("image/jpeg")
          .size((long) 30980)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(8L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .originalName("die-bienenfluesterer_401627[1].jpg")
          .storedName("!8-030b5f71-91d6-4dc8-890c-e27ecd6ab122die-bienenfluesterer_401627[1].jpg")
          .fileType("image/jpeg")
          .size((long) 38958)
          .build();
      filesRepository.save(fileUpload);

    }
  }
}
