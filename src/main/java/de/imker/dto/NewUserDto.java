package de.imker.dto;

import de.imker.models.User;
import lombok.Data;

@Data
public class NewUserDto {
  private String email;
  private String password;
  private String name;
  private String plz;
  private String phone;
  private String image;
  private String secretQuestion;
//  private Boolean isLogin;

}

