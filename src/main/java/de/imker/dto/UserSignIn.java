package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Information for signing in user")
@Data
public class UserSignIn {
    @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
    private String email;
    @Schema(description = "User's password", example = "#123abcABC")
    private String password;

}
