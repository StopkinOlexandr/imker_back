package de.imker;

import com.jpomykala.springhoc.cors.EnableCORS;
import de.imker.InitializationData.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCORS
public class ImkerApp {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(@NotNull CorsRegistry registry) {
        // (allowedOrigins) (addMapping)
        registry.addMapping("/**")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
            .allowedOrigins("*");
      }
    };
  }

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ImkerApp.class, args);

    RequestsInitialization requestsInitialization = context.getBean(RequestsInitialization.class);
    PostsInitialization postsInitialization = context.getBean(PostsInitialization.class);
    FilesInitialization filesInitialization = context.getBean(FilesInitialization.class);
    UserInitialization usersInitialization = context.getBean(UserInitialization.class);
    GoogleMapLinkInitialization googleMapLinkInitialization = context.getBean(GoogleMapLinkInitialization.class);
    EventInitialization eventInitialization = context.getBean(EventInitialization.class);
    GalleryInitialization galleryInitialization = context.getBean(GalleryInitialization.class);
    SliderInitialization sliderInitialization = context.getBean(SliderInitialization.class);
    AddressInitialization addressInitialization = context.getBean(AddressInitialization.class);
    AboutUsInitialisation aboutUsInitialisation = context.getBean(AboutUsInitialisation.class);
    MembersUsInitialisation memberInitialisation = context.getBean(MembersUsInitialisation.class);
    filesInitialization.filesInit();
    eventInitialization.eventInit();
    requestsInitialization.reqInit();
    postsInitialization.postInit();
    usersInitialization.userInit();
    googleMapLinkInitialization.linkInit();
    galleryInitialization.galleryInit();
    sliderInitialization.galleryInit();
    aboutUsInitialisation.aboutUsInit();
    memberInitialisation.MemberInit();
    addressInitialization.addressInit();
  }

}
