package de.imker.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.imker.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("RegistrationController works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
public class RegistrationControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UsersRepository usersRepository;

  @BeforeEach
  public void setUp() {
  }

  @Nested
  @DisplayName("register() method works: ")
  class addUserTests {
    @Test
    void add_user() throws Exception {
      mockMvc.perform(post("/api/register")
              .header("Content-Type", "application/json")
              .content("{\n"
                  + "  \"email\": \"user1@gmail.com\",\n"
                  + "  \"password\": \"!Aqwerty007\"\n"
                  + "}"))
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.id", is(1)))
          .andExpect(jsonPath("$.email", is("user1@gmail.com")))
          .andExpect(jsonPath("$.role", is("USER")))
          .andExpect(jsonPath("$.state", is("CONFIRMED")));

      mockMvc.perform(post("/api/register")
              .header("Content-Type", "application/json")
              .content("{\n"
                  + "  \"email\": \"member1@gmail.com\",\n"
                  + "  \"password\": \"!Aqwerty007\"\n"
                  + "}"))
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.id", is(2)))
          .andExpect(jsonPath("$.email", is("member1@gmail.com")))
          .andExpect(jsonPath("$.role", is("USER")))
          .andExpect(jsonPath("$.state", is("CONFIRMED")));

      mockMvc.perform(post("/api/register")
              .header("Content-Type", "application/json")
              .content("{\n"
                  + "  \"email\": \"admin1@gmail.com\",\n"
                  + "  \"password\": \"!Aqwerty007\"\n"
                  + "}"))
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.id", is(3)))
          .andExpect(jsonPath("$.email", is("admin1@gmail.com")))
          .andExpect(jsonPath("$.role", is("USER")))
          .andExpect(jsonPath("$.state", is("CONFIRMED")));
    }
  }
}
