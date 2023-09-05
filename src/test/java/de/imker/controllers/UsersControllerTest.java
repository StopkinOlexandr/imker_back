package de.imker.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("UsersController works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class UsersControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Nested
  @DisplayName("getUser() and getMyProfile() methods is works: ")
  class GetUserProfile {

    @WithUserDetails(value = "user1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getUserProfileReturnsOkForAuthenticatedUser() throws Exception {
      mockMvc.perform(get("/api/me"))
          .andDo(print())
          .andExpect(status().isOk());
    }

    @WithUserDetails(value = "admin1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getUserAdminById() throws Exception {
      mockMvc.perform(get("/api/users/1"))
          .andDo(print())
          .andExpect(status().isOk());
    }

    @Test
    public void getProfileReturnsForbiddenForNotAuthenticatedUser() throws Exception {
      mockMvc.perform(get("/api/me"))
          .andExpect(status().isUnauthorized());
    }
  }

  @Nested
  @DisplayName("getAllUsers() method - works: ")
  class GetAllUsers {

    @WithUserDetails(value = "user1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void get_all_users() throws Exception {

      mockMvc.perform(get("/api/users?page=0&items=3&orderBy=name&desc=true"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.count", is(3)));
    }
  }

  @Nested
  @DisplayName("deleteUser() method - works: ")
  class DeleteUserTests {


    @WithUserDetails(value = "admin1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteExistsUserByAdmin() throws Exception {
      mockMvc.perform(delete("/api/users/1"))
          .andExpect(status().isOk());
    }

    @WithUserDetails(value = "user1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteExistsUserByUser() throws Exception {
      mockMvc.perform(delete("/api/users/1"))
          .andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "member1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteExistsUserByMember() throws Exception {
      mockMvc.perform(delete("/api/users/1"))
          .andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "admin1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteNotExistUserByAdmin() throws Exception {
      mockMvc.perform(delete("/api/users/4"))
          .andExpect(status().isNotFound());
    }

    @WithUserDetails(value = "user1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteNotExistsUserByUser() throws Exception {
      mockMvc.perform(delete("/api/users/4"))
          .andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "member1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void deleteNotExistsUserByMember() throws Exception {
      mockMvc.perform(delete("/api/users/4"))
          .andExpect(status().isForbidden());
    }
  }

  @Nested
  @DisplayName("updateUser() and updateUserAdmin() method - works: ")
  class UpdateUserTests {

    @WithUserDetails(value = "admin1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void updateExistUserByAdmin() throws Exception {

      mockMvc.perform(put("/api/users/admin/1")
              .header("Content-Type", "application/json")
              .content("""
                  {
                    "name": "Alex Krause",
                    "plz": "01234",
                    "phone": "0123456789012",
                    "image": "1",
                    "state": "BANNED",
                    "role": "MEMBER"
                  }"""))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id", is(1)))
          .andExpect(jsonPath("$.name", is("Alex Krause")))
          .andExpect(jsonPath("$.plz", is("01234")))
          .andExpect(jsonPath("$.phone", is("0123456789012")))
          .andExpect(jsonPath("$.image", is("1")))
          .andExpect(jsonPath("$.role", is("MEMBER")))
          .andExpect(jsonPath("$.state", is("BANNED")));
    }

    @WithUserDetails(value = "member1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void updateExistMemberItSelf() throws Exception {

      mockMvc.perform(put("/api/users/2")
              .header("Content-Type", "application/json")
              .content("""
                  {
                    "name": "Alex Krause",
                    "plz": "01234",
                    "phone": "0123456789012",
                    "image": "1",
                    "state": "BANNED",
                    "role": "MEMBER"
                  }"""))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id", is(2)))
          .andExpect(jsonPath("$.name", is("Alex Krause")))
          .andExpect(jsonPath("$.plz", is("01234")))
          .andExpect(jsonPath("$.phone", is("0123456789012")))
          .andExpect(jsonPath("$.image", is("1")));
    }

    @WithUserDetails(value = "user1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void updateExistUserItSelf() throws Exception {

      mockMvc.perform(put("/api/users/1")
              .header("Content-Type", "application/json")
              .content("""
                  {
                    "name": "Alex Krause",
                    "plz": "01234",
                    "phone": "0123456789012",
                    "image": "1",
                    "state": "BANNED",
                    "role": "MEMBER"
                  }"""))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id", is(1)))
          .andExpect(jsonPath("$.name", is("Alex Krause")))
          .andExpect(jsonPath("$.plz", is("01234")))
          .andExpect(jsonPath("$.phone", is("0123456789012")))
          .andExpect(jsonPath("$.image", is("1")));
    }

    @WithUserDetails(value = "admin1@gmail.com")
    @Test
    @Sql(scripts = "/sql/data.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void updateNotExistUser() throws Exception {
      mockMvc.perform(put("/api/users/admin/4").header("Content-Type", "application/json")
              .content("""
                  {
                    "name": "Alex Krause",
                    "plz": "01234",
                    "phone": "0123456789012",
                    "image": "1",
                    "state": "BANNED",
                    "role": "MEMBER"
                  }"""))
          .andExpect(status().isNotFound());
    }

    @Nested
    @DisplayName("secretQuestions secretQuestionAnswer newPassword method - works: ")
    class RestorePasswordTests {

      @Test
      @Sql(scripts = "/sql/data.sql")
      @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
      void getListOfSecretQuestions() throws Exception {
        mockMvc.perform(post("/api/questions").header("Content-Type", "application/json")
                .content("""
                    {
                      "email": "user1@gmail.com"
                    }"""))
            .andExpect(status().isOk());
      }

      @Test
      @Sql(scripts = "/sql/data.sql")
      @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
      void sendAnswerForSecretQuestions() throws Exception {
        mockMvc.perform(post("/api/question").header("Content-Type", "application/json")
                .content("""
                    {
                       "id": 1,
                       "email": "user1@gmail.com",
                       "secretQuestion": "First car?",
                       "secretQuestionAnswer": "Ford"
                    }"""))
            .andExpect(status().isOk());
      }

      @Test
      @Sql(scripts = "/sql/data.sql")
      @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
      void restorePassword() throws Exception {
        mockMvc.perform(post("/api/restore").header("Content-Type", "application/json")
                .content("""
                    {
                       "id": 1,
                       "newPassword": "!User1password"
                    }"""))
            .andExpect(status().isOk());
      }
    }
  }
}