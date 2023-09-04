package de.imker.controllers.api;

import de.imker.dto.FileUploadDto;
import de.imker.dto.FilesListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tags(value = {
    @Tag(name = "Files")
})
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:5173")
public interface FilesApi {
  @Operation(summary = "Send file to the server", description = "Accessible to all users")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  FileUploadDto uploadFile(@Parameter(required = true, description = "File")
                           @RequestParam("file") MultipartFile file,
                           @Parameter(required = true, description = "Width", example = "300")
                           @RequestParam(value = "width") Integer width,
                           @Parameter(required = true, description = "Height", example = "300")
                           @RequestParam(value = "height") Integer height,
                           @Parameter(required = true, description = "Category (AVATAR, EVENT, GALLERY, POST)", example = "EVENT")
                           @RequestParam(value = "category") String category) throws IOException;

  @Operation(summary = "Get file by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "File not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "File received",
          content = {
              @Content()
          })
  })
  @GetMapping(path = "/{file-id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
  ResponseEntity<Resource> getFileById(@Parameter(required = true, description = "File ID", example = "1")
                                       @PathVariable("file-id") Long fileId);


  @Operation(summary = "Get file info by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "File not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "File info received",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = FileUploadDto.class))
          })
  })
  @GetMapping(path = "/{file-id}/info")
  ResponseEntity<FileUploadDto> getFileInfoById(@Parameter(required = true, description = "File ID", example = "1")
                                                @PathVariable("file-id") Long fileId);


  @Operation(summary = "Get list of files", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Files received",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = FilesListDto.class))
          })
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  FilesListDto getAllFiles(@Parameter(required = true, description = "Page number", example = "0")
                           @RequestParam(value = "page") Integer page,
                           @Parameter(required = true, description = "Number of items per page", example = "3")
                           @RequestParam(value = "items") Integer items,
                           @Parameter(description = "Filter (ALL, AVATAR, EVENT, GALLERY, POST, NONE)", example = "EVENT")
                           @RequestParam(value = "filter") String filter);

  @Operation(summary = "Delete file by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Files deleted",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = FileUploadDto.class))
          })
  })
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(path = "/delete/{file-id}")
  FileUploadDto deleteFileById(@Parameter(required = true, description = "File ID", example = "1")
                               @PathVariable("file-id") Long fileId);
}
