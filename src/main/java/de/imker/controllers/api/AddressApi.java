package de.imker.controllers.api;

import de.imker.dto.AddressDto;
import de.imker.dto.NewAddressDto;
import de.imker.models.Address;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
    @Tag(name = "Address")
})
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:5173")
public interface AddressApi {

  @Operation(summary = "Get address", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Address found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Address loaded",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = Address.class))
          })
  })
  @GetMapping
  AddressDto getAddress();

  @Operation(summary = "Update address", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Address found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Updated address",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class))
          })
  })
  @PutMapping
  AddressDto updateAddress(@RequestBody NewAddressDto newAddress);

}
