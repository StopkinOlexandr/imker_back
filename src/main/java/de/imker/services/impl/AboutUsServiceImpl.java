package de.imker.services.impl;

import de.imker.dto.AboutUsDto;
import de.imker.dto.UpdateAboutUsDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.AboutUs;
import de.imker.repositories.AboutUsRepository;
import de.imker.services.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static de.imker.dto.AboutUsDto.transformAboutUsToAboutUsDto;

@RequiredArgsConstructor
@Service
public class AboutUsServiceImpl implements AboutUsService {

  private final AboutUsRepository aboutUsRepository;


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
    updAboutUs.setImage1(updateAboutUsDto.getImage1());
    updAboutUs.setImage2(updateAboutUsDto.getImage2());

    aboutUsRepository.save(updAboutUs);

    return transformAboutUsToAboutUsDto(updAboutUs);
  }

  private AboutUs getAboutUsOrThrow(Integer aboutUsId) {
    return aboutUsRepository.findById(aboutUsId).orElseThrow(
        () -> new NotFoundException("About Us with id " + aboutUsId + "not found."));
  }
}
