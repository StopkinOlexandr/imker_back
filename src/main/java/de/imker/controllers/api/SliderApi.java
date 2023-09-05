package de.imker.controllers.api;


import de.imker.dto.*;
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
    @Tag(name = "Sliders")
})
@RequestMapping("/api/slider")
@CrossOrigin(origins = "http://localhost:5173")
public interface SliderApi {

  @Operation(summary = "Add slider", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Slider uploaded",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = SliderPhotoDto.class))
          })})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  SliderPhotoDto addPhoto(@Parameter(required = true, description = "NewSliderPhotoDto")
                           @RequestBody NewSliderPhotoDto newSliderPhotoDto);

  @Operation(summary = "Get list of slider photos", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of sliders",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = SliderPhotosDto.class))
          })})
  @GetMapping
  SliderPhotosDto getAllPhotos(@Parameter(required = true, description = "Page number", example = "0")
                                @RequestParam(value = "page") Integer page,
                                @Parameter(required = true, description = "Number of items per page", example = "3")
                                @RequestParam(value = "items") Integer items,
                                @Parameter(required = true,
                                    description = "Sorting field: id, creationTimeSlider",
                                    example = "creationTimeSlider")
                                @RequestParam(value = "orderBy") String orderBy,
                                @Parameter(required = true,
                                    description = "Sorting direction (true = DESK, false = ASK)",
                                    example = "true")
                                @RequestParam(value = "desk") Boolean desk);

  @Operation(summary = "Delete slider photo by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Slider deleted",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = SliderPhotoDto.class))
          })
  })
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(path = "/delete/{photo-id}")
  SliderPhotoDto deletePhotoById(@Parameter(required = true, description = "Slider photo ID", example = "1")
                                  @PathVariable("photo-id") Long photoId);
}
