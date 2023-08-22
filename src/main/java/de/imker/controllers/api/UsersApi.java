package de.imker.controllers.api;

import de.imker.dto.ErrorDto;
import de.imker.dto.NewUserDto;
import de.imker.dto.StandardResponseDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionDto;
import de.imker.dto.UserSigninDto;
import de.imker.dto.UsersDto;
import de.imker.security.details.AuthenticatedUser;
import de.imker.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tags(value = {
    @Tag(name = "Users")
})
@RequestMapping("api/users")
public interface UsersApi {

  @Operation(summary = "Register User")
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
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<UserDto> addUser(
      @Parameter(required = true, description = "User") @RequestBody @Valid NewUserDto newUser);


  @Operation(summary = "Login User")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "User is login",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "Authentication error, e-mail or password incorrect",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
          })
  })

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserDto> loginUser(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserSigninDto loginUser);


  @Operation(summary = "Get User's profile", description = "Allowed to authenticated user. Get current user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Users profile",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "User not authenticated",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
          })
  })
  @GetMapping("/me")
  ResponseEntity<UserDto> getMyProfile(@Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser currentUser);

  //----TODO restore password
  @Operation(summary = "Secret question")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Secret question is answered correctly",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "Wrong answer",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
          })
  })

  @PostMapping("/question")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserIdDto> secretQuestion(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserSecretQuestionDto secretQuestion);

  @Operation(summary = "New password")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Password is changed, user is login",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "Authentication error, e-mail incorrect",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
          })
  })

  @PostMapping("/restore")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserDto> newPassword(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserRestorePwdDto restorePwd);

//-----TODO restore password

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Users list",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UsersDto.class))
          }),
      @ApiResponse(responseCode = "403", description = "Trying sort by forbidden field",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
          })
  })

  @Operation(summary = "Get list of all users")
  @GetMapping
  ResponseEntity<UsersDto> getAllUsers(
      @Parameter(description = "Page number", example = "1")
      @RequestParam(value = "page") Integer page,
      @Parameter(description = "Sort by field. allowed: name, plz, role, state, id")
      @RequestParam(value = "orderBy", required = false) String orderBy,
      @Parameter(description = "set 'true', when revers sort needed")
      @RequestParam(value = "desc", required = false) Boolean desc,
      @RequestParam(value = "filterBy", required = false) String filterBy,
      @RequestParam(value = "filterValue", required = false) String filterValue);


  @Operation(summary = "Delete User", description = "Only for admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Can't find user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
          }),
      @ApiResponse(responseCode = "200", description = "Deleted user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })

  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/{user-id}")
  ResponseEntity<UserDto> deleteUser(
      @Parameter(required = true,
          description = "ID to delete",
          example = "2")
      @PathVariable("user-id") Long userId);

  @Operation(summary = "Update User", description = "Update available for admin and user itself")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Can't find user", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
      }),


      @ApiResponse(responseCode = "200", description = "Updated user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })

  @PutMapping("/{user-id}")
  ResponseEntity<UserDto> updateUser(
      @Parameter(required = true, description = "User ID to update", example = "2")
      @PathVariable("user-id") Long userId,
      @RequestBody UpdateUserDto updateUser);

  @Operation(summary = "Get user by ID", description = "Allowed for all")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "User not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Information about user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @GetMapping("/{user-id}")
  ResponseEntity<UserDto> getUser(@Parameter(required = true, description = "Users ID", example = "2")
  @PathVariable("user-id") Long userId);


}

