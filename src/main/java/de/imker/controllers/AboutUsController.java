package de.imker.controllers;

import de.imker.controllers.api.AboutUsApi;
import de.imker.dto.AboutUsDto;
import de.imker.dto.AboutUsListDto;
import de.imker.dto.MembersDto;
import de.imker.dto.UpdateAboutUsDto;
import de.imker.services.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AboutUsController implements AboutUsApi {

  private final AboutUsService aboutUsService;

  @Override
  public ResponseEntity<AboutUsListDto> getAllAboutUs() {
    return ResponseEntity
        .ok(aboutUsService.getAllAboutUs());
  }

  @Override
  public AboutUsDto getAboutUsById(Integer aboutUsId) {
    return aboutUsService.getAboutUsById(aboutUsId);
  }

  @Override
  public AboutUsDto updateAboutUs(Integer aboutUsId, UpdateAboutUsDto updateAboutUsDto) {
    return aboutUsService.updateAboutUs(aboutUsId, updateAboutUsDto);
  }

}
