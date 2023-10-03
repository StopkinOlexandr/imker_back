package de.imker.services.impl;

import de.imker.dto.AboutUsDto;
import de.imker.dto.AboutUsListDto;
import de.imker.dto.MembersDto;
import de.imker.dto.UpdateAboutUsDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.AboutUs;
import de.imker.models.Member;
import de.imker.repositories.AboutUsRepository;
import de.imker.services.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.imker.dto.AboutUsDto.transformAboutUsToAboutUsDto;
import static de.imker.dto.MemberDto.transformMemberToMemberDto;

@RequiredArgsConstructor
@Service
public class AboutUsServiceImpl implements AboutUsService {

  private final AboutUsRepository aboutUsRepository;
  private final FilesServiceImpl filesService;


  @Override
  public AboutUsDto getAboutUsById(Integer aboutUsId) {
    AboutUs aboutUs = getAboutUsOrThrow(aboutUsId);

    return AboutUsDto.builder()
        .id(aboutUs.getId())
        .titleTop(aboutUs.getTitleTop())
        .descriptionTop(aboutUs.getDescriptionTop())
        .titleBottom(aboutUs.getTitleBottom())
        .descriptionBottom(aboutUs.getDescriptionBottom())
        .image1(aboutUs.getImage1())
        .image2(aboutUs.getImage2())
        .build();
  }

  @Override
  public AboutUsDto updateAboutUs(Integer aboutUsId, UpdateAboutUsDto updateAboutUsDto) {

    AboutUs updAboutUs = getAboutUsOrThrow(aboutUsId);

    updAboutUs.setTitleTop(updateAboutUsDto.getTitleTop());
    updAboutUs.setDescriptionTop(updateAboutUsDto.getDescriptionTop());
    updAboutUs.setTitleBottom(updateAboutUsDto.getTitleBottom());
    updAboutUs.setDescriptionBottom(updateAboutUsDto.getDescriptionBottom());

    if (!updAboutUs.getImage1().equals(updateAboutUsDto.getImage1())){
      filesService.deleteFileById(Long.valueOf(updAboutUs.getImage1()));
    }
    updAboutUs.setImage1(updateAboutUsDto.getImage1());

    if (!updAboutUs.getImage2().equals(updateAboutUsDto.getImage2())){
      filesService.deleteFileById(Long.valueOf(updAboutUs.getImage2()));
    }
    updAboutUs.setImage2(updateAboutUsDto.getImage2());

    aboutUsRepository.save(updAboutUs);

    return transformAboutUsToAboutUsDto(updAboutUs);
  }

  @Override
  public AboutUsListDto getAllAboutUs() {
    List<AboutUs> aboutUsList = aboutUsRepository.findAll();

    return AboutUsListDto.builder()
        .aboutUsAll(transformAboutUsToAboutUsDto(aboutUsList))
        .build();
  }

  private AboutUs getAboutUsOrThrow(Integer aboutUsId) {
    return aboutUsRepository.findById(aboutUsId).orElseThrow(
        () -> new NotFoundException("About Us with id " + aboutUsId + "not found."));
  }
}
