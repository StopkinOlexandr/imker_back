package de.imker.controllers.api;

import de.imker.dto.ErrorDto;
import de.imker.dto.StandardResponseDto;
import de.imker.dto.UpdateUserDto;
import de.imker.dto.UserDto;
import de.imker.dto.UserEmailDto;
import de.imker.dto.UserIdDto;
import de.imker.dto.UserRestorePwdDto;
import de.imker.dto.UserSecretQuestionAnswerDto;
import de.imker.dto.UserSecretQuestionsDto;
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
@RequestMapping("api/")
public interface UsersApi {

  @PreAuthorize("isAuthenticated()")
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
  ResponseEntity<UserDto> getMyProfile(
      @Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser currentUser);

  @Operation(summary = "Secret questions")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get list of secret questions - one according email",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserSecretQuestionsDto.class))
          }),
      @ApiResponse(responseCode = "404", description = "User not found",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
          })
  })
  @PostMapping("/questions")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserSecretQuestionsDto> secretQuestions(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserEmailDto userEmail);

  @Operation(summary = "Secret question and answer for secret question")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Answer for secret question is right",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserIdDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "Wrong question or answer",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
          })
  })
  @PostMapping("/question")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserIdDto> secretQuestionAnswer(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserSecretQuestionAnswerDto secretQuestionAnswer);

  @Operation(summary = "New password")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Password is changed, user is login",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "401", description = "Password change error",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
          })
  })
  @PostMapping("/restore")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserDto> newPassword(
      @Parameter(required = true, description = "User") @RequestBody @Valid UserRestorePwdDto restorePwd);

  @Operation(summary = "Get list of all users")
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
  @GetMapping("/users")
  ResponseEntity<UsersDto> getAllUsers(
      @Parameter(required = true, description = "Page number", example = "0")
      @RequestParam(value = "page") Integer page,
      @Parameter(required = true, description = "Number of items per page", example = "3")
      @RequestParam(value = "items") Integer items,
      @Parameter(required = true,
          description = "Sorting field: id, name, email, role",
          example = "name")
      @RequestParam(value = "orderBy") String orderBy,
      @Parameter(required = true,
          description = "Sorting direction (true = DESC, false = ASС)",
          example = "true")
      @RequestParam(value = "desc") Boolean desc);

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
  @DeleteMapping("/users/{user-id}")
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
  @PutMapping("/users/{user-id}")
  ResponseEntity<UserDto> updateUser(
      @Parameter(required = true, description = "User ID to update", example = "2")
      @PathVariable("user-id") Long userId,
      @RequestBody UpdateUserDto updateUser);

  @Operation(summary = "Change user's data by ADMIN",
      description = "Change user's data including role from USER to MEMBER or ADMIN and back")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Can't find user", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
      }),
      @ApiResponse(responseCode = "200", description = "Updated user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @PreAuthorize("hasAuthority('ADMIN')")
  @PutMapping("/users/admin/{user-id}")
  ResponseEntity<UserDto> updateUserAdmin(
      @Parameter(required = true, description = "User Id for update", example = "2")
      @PathVariable("user-id") Long userId,
      @RequestBody UpdateUserDto updateUser);

  @Operation(summary = "Get user by ID", description = "Allowed for all")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "User not found",
          content = {@Content()}),
      @ApiResponse(responseCode = "200", description = "Information about user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/users/{user-id}")
  ResponseEntity<UserDto> getUser(
      @Parameter(required = true, description = "Users ID", example = "2")
      @PathVariable("user-id") Long userId);
}

