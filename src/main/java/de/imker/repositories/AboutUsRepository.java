package de.imker.repositories;

import de.imker.models.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutUsRepository extends JpaRepository<AboutUs, Integer> {

  AboutUs getAboutUsById(Integer id);
}
