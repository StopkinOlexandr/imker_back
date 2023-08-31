package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Users list")
public class UsersDto {

  @Schema(description = "Website users")
  private List<UserDto> users;

  @Schema(description = "Total amount of users", example = "1")
  private Integer count;

  @Schema(description = "Number of pages", example = "1")
  private Integer pages;
}
