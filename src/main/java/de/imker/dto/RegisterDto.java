package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {
  @Schema(description = "User's email", example = "a@abc.com")
  @Email
  @NotNull
  @NotBlank
  private String email;

  @Schema(description = "User's password", example = "!Aqwerty007")
  @NotBlank
  @Size(min = 6, max = 100)
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{5,}$", message = "Weak password")
  private String password;

  @Schema(description = "User's name", example = "Alex Krause")
  private String name;

  @Size(min = 5, max = 5)
  @Pattern(regexp = "^\\d{5}$", message = "Wrong PLZ")
  @Schema(description = "User's PLZ", example = "01234")
  private String plz;

  @Schema(description = "User's phone", example = "0123456789")
  private String phone;

//  @NotBlank
  @Schema(description = "User's secret question ", example = "My first car?")
  private String secretQuestion;

//  @NotBlank
  @Schema(description = "User's answer for secret question ", example = "My first car? - Ford")
  private String answerSecretQuestion;
}
