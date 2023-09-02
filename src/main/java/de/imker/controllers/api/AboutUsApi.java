package de.imker.controllers.api;

import de.imker.dto.AboutUsDto;
import de.imker.dto.AboutUsListDto;
import de.imker.dto.MembersDto;
import de.imker.dto.UpdateAboutUsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/aboutus")
@Tags(value = {
    @Tag(name = "AboutUs")
})
@CrossOrigin(origins = "http://localhost:5173")

public interface AboutUsApi {

  @Operation(summary = "Get AboutUs by Id", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get Member by Id",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  AboutUsDto.class))
          }),
      @ApiResponse(responseCode = "404", description = "AboutUs with Id Not Found",
          content = {
              @Content()
          })
  })

  @GetMapping("/{aboutus-id}")
  AboutUsDto getAboutUsById(
      @Parameter(required = true, description = "Get AboutUs by Id",
          example = "1")
      @PathVariable("aboutus-id") Integer aboutusId);

  @Operation(summary = "Get texts AboutUs", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get texts AboutUs",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  AboutUsDto.class))
          }),
      @ApiResponse(responseCode = "404", description = "AboutUs text Not Found",
          content = {
              @Content()
          })
  })

  @GetMapping("")
  ResponseEntity<AboutUsListDto> getAllAboutUs();


  @Operation(summary = "Update AboutUs by Id", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "AboutUs Updated",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  AboutUsDto.class))
          }),
      @ApiResponse(responseCode = "404", description = "AboutUs not changed or not found.",
          content = {
              @Content()
          })
  })

  @PutMapping("/update/{aboutusId}")
  AboutUsDto updateAboutUs(
      @Parameter(required = true, description = "ID AboutUs To Update",
          example = "1")
      @PathVariable("aboutusId") Integer aboutusId,
      @RequestBody UpdateAboutUsDto updateAboutUsDto);


//  @Operation(summary = "Create AboutUs", description = "Avialable Only For Admin")
//  @ApiResponses(value = {
//      @ApiResponse(responseCode = "200", description = "Text for About Us created",
//          content = {
//              @Content(mediaType = "application/json", schema = @Schema(implementation =
//                  AboutUsDto.class))
//          }),
//      @ApiResponse(responseCode = "404", description = "Description AboutUs not found",
//          content = {
//              @Content()
//          }),
//
//  })
//
//  @PostMapping
//  ResponseEntity<AboutUsDto> addAboutUs(@RequestBody NewAboutUsDto newAboutUs);

}
