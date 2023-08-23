package de.imker.dto;

import de.imker.models.User;
import de.imker.validation.constrains.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Information for adding new user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {

  @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
  @Email
  @NotNull
  @NotBlank
  private String email;

  @Schema(description = "User's password", example = "#123abcABC")
  @NotBlank
  @Size(min = 7, max = 100)
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Weak password")
  private String password;

  @Schema(description = "User's name", example = "Alex Krause")
  private String name;

  @Schema(description = "User's PLZ", example = "01234")
  private String plz;

  @Schema(description = "User's phone", example = "0123456789")
  private String phone;

  @Schema(description = "User's secret question ", example = "My first car?")
  private String secretQuestion;

  @Schema(description = "User's answer for secret question ", example = "My first car? - Ford")
  private String answerSecretQuestion;


}

