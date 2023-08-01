package de.imker.dto;

import de.imker.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Information for adding new user")
@Data
public class NewUserDto {
  @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
  private String email;
  @Schema(description = "User's password", example = "#123abcABC")
  private String password;
  @Schema(description = "User's name", example = "Alex Krause")
  private String name;
  @Schema(description = "User's PLZ", example = "01234")
  private String plz;
  @Schema(description = "User's phone", example = "0123456789")
  private String phone;
//  private String image;
  @Schema(description = "User's answer for secret question ", example = "My first car? - Ford")
  private String secretQuestion;
//  private Boolean isLogin;

}

