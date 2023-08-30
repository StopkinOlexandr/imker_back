package de.imker.services;


import de.imker.dto.AboutUsDto;
import de.imker.dto.UpdateAboutUsDto;

public interface AboutUsService {

  AboutUsDto getAboutUsById(Integer aboutUsId);

  AboutUsDto updateAboutUs(Integer aboutUsId, UpdateAboutUsDto updateAboutUsDto);


}
