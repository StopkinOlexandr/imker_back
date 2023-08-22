package de.imker.controllers.api;

import de.imker.dto.GoogleMapDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
    @Tag(name = "Google Map")
})
@RequestMapping("/api/googlemap")
@CrossOrigin(origins = "http://localhost:5173")
public interface GoogleMapApi {

  @Operation(summary = "Get Google Map link", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Link not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Link loaded",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = GoogleMapDto.class))
          })
  })
  @GetMapping
  GoogleMapDto getGoogleMapLink();

  @Operation(summary = "Update Google Map link", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Link not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Updated link",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = GoogleMapDto.class))
          })
  })
  @PutMapping
  GoogleMapDto updateGoogleMapLink(@RequestBody GoogleMapDto newLink);
}
