package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Information for restore password - email")
@Data
public class UserEmailDto {
    @Schema(description = "User's e-main", example = "aaa@bbb.ccc")
    private String email;
   }
