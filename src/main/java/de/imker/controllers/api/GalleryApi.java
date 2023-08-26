package de.imker.controllers.api;


import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.GalleryPhotosDto;
import de.imker.dto.NewGalleryPhotoDto;
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
    @Tag(name = "Gallery")
})
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "http://localhost:5173")
public interface GalleryApi {

  @Operation(summary = "Add photo to the gallery", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Photo uploaded",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = GalleryPhotoDto.class))
          })})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  GalleryPhotoDto addPhoto(@Parameter(required = true, description = "NewGalleryPhotoDto")
                           @RequestBody NewGalleryPhotoDto newGalleryPhotoDto);

  @Operation(summary = "Get list of gallery photos", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of photos",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = GalleryPhotosDto.class))
          })})
  @GetMapping
  GalleryPhotosDto getAllPhotos(@Parameter(required = true, description = "Page number", example = "0")
                                @RequestParam(value = "page") Integer page,
                                @Parameter(required = true, description = "Number of items per page", example = "3")
                                @RequestParam(value = "items") Integer items,
                                @Parameter(required = true,
                                    description = "Sorting field: id, creationTimePhoto",
                                    example = "creationTimePhoto")
                                @RequestParam(value = "orderBy") String orderBy,
                                @Parameter(required = true,
                                    description = "Sorting direction (true = DESK, false = ASK)",
                                    example = "true")
                                @RequestParam(value = "desk") Boolean desk);

  @Operation(summary = "Delete gallery photo by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Photo deleted",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = GalleryPhotoDto.class))
          })
  })
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(path = "/delete/{photo-id}")
  GalleryPhotoDto deletePhotoById(@Parameter(required = true, description = "Gallery photo ID", example = "1")
                                  @PathVariable("photo-id") Long photoId);
}
