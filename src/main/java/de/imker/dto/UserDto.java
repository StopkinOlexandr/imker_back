package de.imker.dto;

import de.imker.models.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
  private Long id;
  private String email;
  private String role;
  private String state;

  public static UserDto from(User user) {
    return UserDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .state(user.getState().name())
        .role(user.getRole().name())
        .build();
  }

  public static List<UserDto> from(List<User> users) {
    return users.stream()
        .map(UserDto::from)
        .collect(Collectors.toList());
  }
}
