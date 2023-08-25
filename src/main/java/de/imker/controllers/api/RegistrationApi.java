package de.imker.controllers.api;

import de.imker.dto.RegisterDto;
import de.imker.dto.UserDto;
import de.imker.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/register")
@Tags(value =
@Tag(name = "Users")
)
public interface RegistrationApi {

  //
  @Operation(summary = "Create User", description = "Allowed for all")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User created",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "400", description = "Validation error",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
          })
  })
  @PostMapping
  ResponseEntity<UserDto> register(@RequestBody @Valid RegisterDto registerData);
}


