package de.imker.controllers.api;

import de.imker.dto.EventDto;
import de.imker.dto.EventsDto;
import de.imker.dto.NewEventDto;
import de.imker.dto.NewUserDto;
import de.imker.dto.UpdateEventDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UsersDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tags(value = {
@Tag(name = "Users")
})
@RequestMapping("api/users")
public interface UsersApi {
  @Operation(summary = "Creating User")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  UserDto addUser(@RequestBody NewUserDto newUser);

  @Operation(summary = "Get all users")
  @GetMapping
  UsersDto getAllUsers();

  @Operation(summary = "Delete User", description = "Only for admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Can't find user", content = {
          @Content()
      }),
      @ApiResponse(responseCode = "200", description = "Deleted user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @DeleteMapping("/{user-id}")
  UserDto deleteUser(@Parameter(required = true, description = "ID to delete", example = "2") @PathVariable("user-id") Long userId);

  @Operation(summary = "Update User", description = "Update available only for admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Can't find user", content = {
          @Content()
      }),
      @ApiResponse(responseCode = "200", description = "Updated user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @PutMapping("/{user-id}")
  UserDto updateUser(@Parameter(required = true, description = "ID to update", example = "2")
  @PathVariable("user-id") Long userId,
      @RequestBody UpdateUserDto updateUser);


}
