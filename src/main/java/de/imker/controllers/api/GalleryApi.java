package de.imker.controllers.api;


import de.imker.dto.GalleryPhotoDto;
import de.imker.dto.NewGalleryPhotoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  GalleryPhotoDto addPhoto(@Parameter(required = true, description = "NewGalleryPhotoDto")
                          @RequestBody NewGalleryPhotoDto newGalleryPhotoDto);
}
