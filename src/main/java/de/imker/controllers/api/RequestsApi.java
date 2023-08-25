package de.imker.controllers.api;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
    @Tag(name = "Requests")
})
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/requests")
public interface RequestsApi {


  @Operation(summary = "Create user request", description = "Accessible to all users")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  RequestDto addRequest(@Parameter(required = true, description = "Request")
                        @RequestBody NewRequestDto newRequest);

  @Operation(summary = "Get all requests list", description = "Accessible to all users")
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  RequestsDto getAllRequests();

  @Operation(summary = "Delete request", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Request not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Deleted request",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDto.class))
          })
  })
  @DeleteMapping("/{request-id}")
  RequestDto deleteRequest(@Parameter(required = true, description = "Request id", example = "2")
                           @PathVariable("request-id") Long idRequest);
}
