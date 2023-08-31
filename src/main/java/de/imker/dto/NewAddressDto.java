package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "New address")
public class NewAddressDto {

  @Schema(description = "New address",
      example = "29693 Eickeloh, Walsroder Str. 3")
  private String address;
  @Schema(description = "New phone number",
      example = "0516-290-12-66")
  private String phone;
  @Schema(description = "New e-mail",
      example = "Imkerverein-Ahlden@t-online.de")
  private String email;
}
