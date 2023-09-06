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
          .storedName("!001-7f1bb7eb-231b-4535-b917-ca7819841540kopfbild_vereine_03[1].jpg")
          .fileType("image/jpeg")
          .size((long) 33632)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(2L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("header-ratgeber-bienen[1].jpg")
          .storedName("!002-b3d40dd7-5813-4ecc-b1fc-188e685061ddheader-ratgeber-bienen[1].jpg")
          .fileType("image/jpeg")
          .size((long) 27381)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(3L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("5376145_original2560_1zX9HW_qP3j6P[1].jpg")
          .storedName("!003-871d3f92-bff9-4333-a0bd-62e63d3d37845376145_original2560_1zX9HW_qP3j6P[1].jpg")
          .fileType("image/jpeg")
          .size((long) 21111)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(4L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("honigbienen-01[1].jpg")
          .storedName("!004-707c4d7c-6fc7-4f8f-92b8-c287f1520442honigbienen-01[1].jpg")
          .fileType("image/jpeg")
          .size((long) 75514)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(5L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("w940_h528_x470_y264_5736869295a8f6e7[1].jpg")
          .storedName("!005-6ed43282-1516-4578-ba2c-1327982b4365w940_h528_x470_y264_5736869295a8f6e7[1].jpg")
          .fileType("image/jpeg")
          .size((long) 32690)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(6L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("Honigvielfalt[1].jpg")
          .storedName("!006-01c11f85-b8b9-46df-99c1-51cd7b456099Honigvielfalt[1].jpg")
          .fileType("image/jpeg")
          .size((long) 41939)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(7L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("Honigglaeser_980_rdax_720x316_80[1].jpg")
          .storedName("!007-ec0b4ac4-73de-4251-8a11-ef387c42c8a8Honigglaeser_980_rdax_720x316_80[1].jpg")
          .fileType("image/jpeg")
          .size((long) 30980)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(8L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("die-bienenfluesterer_401627[1].jpg")
          .storedName("!008-030b5f71-91d6-4dc8-890c-e27ecd6ab122die-bienenfluesterer_401627[1].jpg")
          .fileType("image/jpeg")
          .size((long) 38958)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(9L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.POST)
          .originalName("HONIGSORTEN.jpg")
          .storedName("!009-74d4eab8-0606-4e86-91f6-daebdcaa024eHONIGSORTEN.jpg")
          .fileType("image/jpeg")
          .size((long) 51588)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(21L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider2.jpg")
          .storedName("!021-c817a7a6-dd2e-4604-8e07-c4a838fa2712slider2.jpg")
          .fileType("image/jpeg")
          .size((long) 63130)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(22L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider1.jpg")
          .storedName("!022-9123b046-3cf6-45d0-a898-7488305eb6efslider1.jpg")
          .fileType("image/jpeg")
          .size((long) 62515)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(23L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider3.jpg")
          .storedName("!023-4d9e9ab2-fb20-4e59-b70f-0a0e31397291slider3.jpg")
          .fileType("image/jpeg")
          .size((long) 93952)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(24L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider4.jpg")
          .storedName("!024-c5d4c8b7-64eb-4f29-9c18-ce59e2a4f380slider4.jpg")
          .fileType("image/jpeg")
          .size((long) 82234)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(25L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.SLIDER)
          .originalName("slider5.jpg")
          .storedName("!025-8d4c45e5-45ed-4a7d-a135-0ff0aba01520slider5.jpg")
          .fileType("image/jpeg")
          .size((long) 51540)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(91L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!091Event1.jpg")
          .storedName("!091-f9b2c21f-76c6-43a1-8f40-0365924ff952!091Event1.jpg")
          .fileType("image/jpeg")
          .size((long) 15780)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(92L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!092EventHonigFest.jpg")
          .storedName("!092-297a0746-3d2f-4755-8b5a-795d87a07c0c!092EventHonigFest.jpg")
          .fileType("image/jpeg")
          .size((long) 13569)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(93L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!093Beene.jpg")
          .storedName("!093-267238124-e0a9-400a-aa03-c0014ae5c3e7!093Beene.jpg")
          .fileType("image/jpeg")
          .size((long) 14079)
          .build();


      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(94L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!094Imker.jpg")
          .storedName("!094-cb3312f8-f586-4dd0-b0ee-b39601adc6d1!094Imker.jpg")
          .fileType("image/jpeg")
          .size((long) 19887)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(95L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!095.jpg")
          .storedName("!095-2cce7697-dee7-4287-8615-6dd854438024!095.jpg")
          .fileType("image/jpeg")
          .size((long) 14159)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(96L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!096.jpg")
          .storedName("!096-85ea824b-55f5-4f76-855e-395020d0a100!096.jpg")
          .fileType("image/jpeg")
          .size((long) 16465)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(97L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!097.jpg")
          .storedName("!097-c11959a3-d567-4c87-86f3-16747a6c1944!097.jpg")
          .fileType("image/jpeg")
          .size((long) 32606)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(98L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!098.jpg")
          .storedName("!098-41fcf68e-b727-487b-b715-834d7aa32d71!098.jpg")
          .fileType("image/jpeg")
          .size((long) 11817)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(99L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!099.jpg")
          .storedName("!099-8ece9cf2-321a-4709-9cb7-d33da6f47392!099.jpg")
          .fileType("image/jpeg")
          .size((long) 9841)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(100L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!100.jpg")
          .storedName("!100-ba45a882-5720-4871-978e-aa9e2d52c9dc!100.jpg")
          .fileType("image/jpeg")
          .size((long) 10605)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(101L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.EVENT)
          .originalName("!101.jpg")
          .storedName("!101-d6a53983-55fc-4bfd-be8d-4b0240e119d0!101.jpg")
          .fileType("image/jpeg")
          .size((long) 7924)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(121L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("1.jpg")
          .storedName("!121-66b64a42-5e99-44e3-b526-b429e5220c3d1.jpg")
          .fileType("image/jpeg")
          .size(58679L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(122L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("2.jpg")
          .storedName("!122-c5a10450-9459-4bee-af60-12de1a5fce272.jpg")
          .fileType("image/jpeg")
          .size(77799L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(123L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("3.jpg")
          .storedName("!123-2c2c082d-35b6-4268-8475-3a122e723f5f3.jpg")
          .fileType("image/jpeg")
          .size(66074L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(124L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("4.jpg")
          .storedName("!124-598cbca8-6c52-4630-8386-c9bcff3de4634.jpg")
          .fileType("image/jpeg")
          .size(107694L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(125L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("5.jpg")
          .storedName("!125-cf50650d-343d-44ca-8230-24eb9c4e5e3f5.jpg")
          .fileType("image/jpeg")
          .size(68925L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(126L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("6.jpg")
          .storedName("!126-944b0312-9fe0-49e7-9148-1ca6d867cad16.jpg")
          .fileType("image/jpeg")
          .size(77002L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(127L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("7.jpg")
          .storedName("!127-29117ab1-1abe-4ebc-9890-dd98dd091f6e7.jpg")
          .fileType("image/jpeg")
          .size(76146L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(128L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("8.jpg")
          .storedName("!128-9ab1d282-a3df-4679-bb1c-337e8e2e17668.jpg")
          .fileType("image/jpeg")
          .size(70145L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(129L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("9.jpg")
          .storedName("!129-bf399efd-2a43-45a9-b2c7-04cedfaaeba69.jpg")
          .fileType("image/jpeg")
          .size(66701L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(130L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("10.jpg")
          .storedName("!130-c86c559d-0a8e-425a-bdf8-b9ebae02fef110.jpg")
          .fileType("image/jpeg")
          .size(39669L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(131L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("11.jpg")
          .storedName("!131-4bd96f81-787a-438f-9d33-732645c7de1d11.jpg")
          .fileType("image/jpeg")
          .size(89565L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(132L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("12.jpg")
          .storedName("!132-1f53de35-aea3-4ab5-b6c4-861db6b5154a12.jpg")
          .fileType("image/jpeg")
          .size(78942L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(133L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("13.jpg")
          .storedName("!133-f0b91292-aefc-4fa5-aa04-27ac00da3fba13.jpg")
          .fileType("image/jpeg")
          .size(157482L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(134L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("14.jpg")
          .storedName("!134-06a70143-5616-4dee-87ef-3f09e9aa34b414.jpg")
          .fileType("image/jpeg")
          .size(81263L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(135L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("15.jpg")
          .storedName("!135-22cd5c91-541e-4af9-a58e-9337f02d757e15.jpg")
          .fileType("image/jpeg")
          .size(85559L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(136L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("16.jpg")
          .storedName("!136-7f75a0a6-2d02-470a-b1d6-030877720b1816.jpg")
          .fileType("image/jpeg")
          .size(131179L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(137L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("17.jpg")
          .storedName("!137-efa4fdbf-66ce-4f52-8e5e-e19bf060d84217.jpg")
          .fileType("image/jpeg")
          .size(87938L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(138L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("18.jpg")
          .storedName("!138-bf81a762-2ce6-4470-adc2-fd29656ac6ff18.jpg")
          .fileType("image/jpeg")
          .size(93108L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(139L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("19.jpg")
          .storedName("!139-cdbf26a1-c5c6-47b4-a3da-2192040f126019.jpg")
          .fileType("image/jpeg")
          .size(108041L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(140L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("20.jpg")
          .storedName("!140-99699718-9663-4ec7-9ae7-0494dd13e1c320.jpg")
          .fileType("image/jpeg")
          .size(88520L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(141L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("21.jpg")
          .storedName("!141-6014c067-0f84-49d4-92bf-66c4e78c008221.jpg")
          .fileType("image/jpeg")
          .size(120809L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(142L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("22.jpg")
          .storedName("!142-119672f8-faac-41d6-b0ae-5f5b1303308222.jpg")
          .fileType("image/jpeg")
          .size(122233L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(143L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("23.jpg")
          .storedName("!143-2b552989-291b-47ba-a464-0e3a3b3ae4ef23.jpg")
          .fileType("image/jpeg")
          .size(137130L)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(144L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.GALLERY)
          .originalName("24.jpg")
          .storedName("!144-df0e1f18-bf73-4b40-bbc3-4a2e5e17879024.jpg")
          .fileType("image/jpeg")
          .size(78516L)
          .build();
      filesRepository.save(fileUpload);


      fileUpload = FileUpload.builder()
          .id(151L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team1.jpg")
          .storedName("!151-c5d57669-2182-4e00-8db1-a1eb9318a4f9team1.jpg")
          .fileType("image/jpeg")
          .size((long) 17179)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(153L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team2.jpg")
          .storedName("!153-63fb33c8-6fe5-41e0-9752-d89a72b3244bteam2.jpg")
          .fileType("image/jpeg")
          .size((long) 14377)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(152L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("team3.jpg")
          .storedName("!152-66cae5ef-ff98-4455-a6d5-dd44b47776e3team3.jpg")
          .fileType("image/jpeg")
          .size((long) 14418)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(154L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("about_1.jpg")
          .storedName("!154-7e9a519c-60ab-4967-9e00-01a5326a736aabout_1.jpg")
          .fileType("image/jpeg")
          .size((long) 49988)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(155L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("about_2.jpg")
          .storedName("!155-73b462ca-1ecd-4ed7-8d67-74965dedc223about_2.jpg")
          .fileType("image/jpeg")
          .size((long) 80844)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(156L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("bee.png")
          .storedName("!156-b74a0c87-c6b1-408e-b5c8-65be8bd374f9bee.png")
          .fileType("image/jpeg")
          .size((long) 26551)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(157L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images1.jpg")
          .storedName("!157-c771cc8c-bc98-4fcd-a697-c46c299a3855images1.jpg")
          .fileType("image/jpeg")
          .size((long) 12286)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(158L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images6.jpg")
          .storedName("!158-46d9e6f2-1336-4de3-ab7a-b7a09c68e51fimages6.jpg")
          .fileType("image/jpeg")
          .size((long) 12147)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(159L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images8.jpg")
          .storedName("!159-393fcffb-2d8a-41be-85d9-c76f73fe5f9cimages8.jpg")
          .fileType("image/jpeg")
          .size((long) 12631)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(160L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images9.jpg")
          .storedName("!160-9a7911ea-4918-4f0c-ac5a-98818812901fimages9.jpg")
          .fileType("image/jpeg")
          .size((long) 8918)
          .build();
      filesRepository.save(fileUpload);

      fileUpload = FileUpload.builder()
          .id(161L)
          .creationTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
          .category(FileUpload.Category.AVATAR)
          .originalName("images10.jpg")
          .storedName("!161-bc750daf-eacc-4394-800b-65fafdf962bcimages10.jpg")
          .fileType("image/jpeg")
          .size((long) 9038)
          .build();
      filesRepository.save(fileUpload);


    }
  }
}
