package de.imker.dto;

import de.imker.models.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO for address")
public class AddressDto {

  @Schema(description = "ID in DB: always = 1 ", example = "1")
  private Long id;

  @Schema(description = "Address",
      example = "29693 Eickeloh, Walsroder Str. 3")
  private String address;
  @Schema(description = "Phone number",
      example = "0516-290-12-66")
  private String phone;
  @Schema(description = "E-mail",
      example = "Imkerverein-Ahlden@t-online.de")
  private String email;

  public static AddressDto from(Address address) {
    return AddressDto.builder()
        .id(address.getId())
        .address(address.getAddress())
        .phone(address.getPhone())
        .email(address.getEmail())
        .build();
  }
}
