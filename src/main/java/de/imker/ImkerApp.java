package de.imker;

import de.imker.InitializationData.FilesInitialization;
import de.imker.InitializationData.PostsInitialization;
import de.imker.InitializationData.RequestsInitialization;
import de.imker.InitializationData.UserInitialization;
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
        registry.addMapping("/**").allowedOrigins("*");
      }
    };
  }

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ImkerApp.class, args);

    RequestsInitialization requestsInitialization = context.getBean(RequestsInitialization.class);
    PostsInitialization postsInitialization = context.getBean(PostsInitialization.class);
    FilesInitialization filesInitialization = context.getBean(FilesInitialization.class);
    UserInitialization usersInitialization = context.getBean(UserInitialization.class);

    requestsInitialization.reqInit();
    postsInitialization.postInit();
    filesInitialization.filesInit();
    usersInitialization.userInit();
  }

}
