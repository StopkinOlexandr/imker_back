package de.imker.InitializationData;

import de.imker.models.FileUpload;
import de.imker.repositories.FilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FilesInitialization {

  private final FilesRepository filesRepository;


  public void filesInit() {
    List<FileUpload> filesList = filesRepository.findAll();
    if (filesList.size() == 0) {
      for (int i = 0; i < 200; i++) {
        FileUpload fileUpload = FileUpload.builder()
            .category(FileUpload.Category.NONE)
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
          .category(FileUpload.Category.POST)
          .originalName("kopfbild_vereine_03[1].jpg")
          .storedName("1")
          .fileType("image/jpeg")
          .size((long) 33632)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(2L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("header-ratgeber-bienen[1].jpg")
          .storedName("2")
          .fileType("image/jpeg")
          .size((long) 27381)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(3L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("5376145_original2560_1zX9HW_qP3j6P[1].jpg")
          .storedName("3")
          .fileType("image/jpeg")
          .size((long) 21111)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(4L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("honigbienen-01[1].jpg")
          .storedName("4")
          .fileType("image/jpeg")
          .size((long) 75514)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(5L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("w940_h528_x470_y264_5736869295a8f6e7[1].jpg")
          .storedName("5")
          .fileType("image/jpeg")
          .size((long) 32690)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(6L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("Honigvielfalt[1].jpg")
          .storedName("6")
          .fileType("image/jpeg")
          .size((long) 41939)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(7L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("Honigglaeser_980_rdax_720x316_80[1].jpg")
          .storedName("7")
          .fileType("image/jpeg")
          .size((long) 30980)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(8L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("die-bienenfluesterer_401627[1].jpg")
          .storedName("8")
          .fileType("image/jpeg")
          .size((long) 38958)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(9L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("HONIGSORTEN.jpg")
          .storedName("9")
          .fileType("image/jpeg")
          .size((long) 51588)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(21L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider2.jpg")
          .storedName("21")
          .fileType("image/jpeg")
          .size((long) 63130)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(22L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider1.jpg")
          .storedName("22")
          .fileType("image/jpeg")
          .size((long) 62515)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(23L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider3.jpg")
          .storedName("23")
          .fileType("image/jpeg")
          .size((long) 93952)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(24L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider4.jpg")
          .storedName("24")
          .fileType("image/jpeg")
          .size((long) 82234)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(25L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider5.jpg")
          .storedName("25")
          .fileType("image/jpeg")
          .size((long) 51540)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(91L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!091Event1.jpg")
          .storedName("91")
          .fileType("image/jpeg")
          .size((long) 15780)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(92L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!092EventHonigFest.jpg")
          .storedName("92")
          .fileType("image/jpeg")
          .size((long) 13569)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(93L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!093Beene.jpg")
          .storedName("93")
          .fileType("image/jpeg")
          .size((long) 14079)
          .build();


      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(94L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!094Imker.jpg")
          .storedName("94")
          .fileType("image/jpeg")
          .size((long) 19887)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(95L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!095.jpg")
          .storedName("95")
          .fileType("image/jpeg")
          .size((long) 14159)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(96L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!096.jpg")
          .storedName("96")
          .fileType("image/jpeg")
          .size((long) 16465)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(97L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!097.jpg")
          .storedName("97")
          .fileType("image/jpeg")
          .size((long) 32606)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(98L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!098.jpg")
          .storedName("98")
          .fileType("image/jpeg")
          .size((long) 11817)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(99L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!099.jpg")
          .storedName("99")
          .fileType("image/jpeg")
          .size((long) 9841)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(100L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!100.jpg")
          .storedName("100")
          .fileType("image/jpeg")
          .size((long) 10605)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(101L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!101.jpg")
          .storedName("101")
          .fileType("image/jpeg")
          .size((long) 7924)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(121L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("1.jpg")
          .storedName("121")
          .fileType("image/jpeg")
          .size(58679L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(122L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("2.jpg")
          .storedName("122")
          .fileType("image/jpeg")
          .size(77799L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(123L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("3.jpg")
          .storedName("123")
          .fileType("image/jpeg")
          .size(66074L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(124L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("4.jpg")
          .storedName("124")
          .fileType("image/jpeg")
          .size(107694L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(125L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("5.jpg")
          .storedName("125")
          .fileType("image/jpeg")
          .size(68925L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(126L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("6.jpg")
          .storedName("126")
          .fileType("image/jpeg")
          .size(77002L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(127L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("7.jpg")
          .storedName("127")
          .fileType("image/jpeg")
          .size(76146L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(128L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("8.jpg")
          .storedName("128")
          .fileType("image/jpeg")
          .size(70145L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(129L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("9.jpg")
          .storedName("129")
          .fileType("image/jpeg")
          .size(66701L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(130L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("10.jpg")
          .storedName("130")
          .fileType("image/jpeg")
          .size(39669L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(131L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("11.jpg")
          .storedName("131")
          .fileType("image/jpeg")
          .size(89565L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(132L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("12.jpg")
          .storedName("132")
          .fileType("image/jpeg")
          .size(78942L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(133L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("13.jpg")
          .storedName("133")
          .fileType("image/jpeg")
          .size(157482L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(134L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("14.jpg")
          .storedName("134")
          .fileType("image/jpeg")
          .size(81263L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(135L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("15.jpg")
          .storedName("135")
          .fileType("image/jpeg")
          .size(85559L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(136L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("16.jpg")
          .storedName("136")
          .fileType("image/jpeg")
          .size(131179L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(137L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("17.jpg")
          .storedName("137")
          .fileType("image/jpeg")
          .size(87938L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(138L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("18.jpg")
          .storedName("138")
          .fileType("image/jpeg")
          .size(93108L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(139L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("19.jpg")
          .storedName("139")
          .fileType("image/jpeg")
          .size(108041L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(140L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("20.jpg")
          .storedName("140")
          .fileType("image/jpeg")
          .size(88520L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(141L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("21.jpg")
          .storedName("141")
          .fileType("image/jpeg")
          .size(120809L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(142L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("22.jpg")
          .storedName("142")
          .fileType("image/jpeg")
          .size(122233L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(143L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("23.jpg")
          .storedName("143")
          .fileType("image/jpeg")
          .size(137130L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(144L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("24.jpg")
          .storedName("144")
          .fileType("image/jpeg")
          .size(78516L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(151L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team1.jpg")
          .storedName("151")
          .fileType("image/jpeg")
          .size((long) 14087)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(152L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team3.jpg")
          .storedName("152")
          .fileType("image/jpeg")
          .size((long) 14418)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(153L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team2.jpg")
          .storedName("153")
          .fileType("image/jpeg")
          .size((long) 14377)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(154L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("about_1.jpg")
          .storedName("154")
          .fileType("image/jpeg")
          .size((long) 49988)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(155L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("about_2.jpg")
          .storedName("155")
          .fileType("image/jpeg")
          .size((long) 80844)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(156L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("bee.jpg")
          .storedName("156")
          .fileType("image/jpeg")
          .size((long) 26551)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(157L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images1.jpg")
          .storedName("157")
          .fileType("image/jpeg")
          .size((long) 12286)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(158L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images6.jpg")
          .storedName("158")
          .fileType("image/jpeg")
          .size((long) 12147)
          .build();
      filesRepository.save(fileUpload);

    }
  }
}
