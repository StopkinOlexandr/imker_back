package de.imker.controllers;

import de.imker.controllers.api.AddressApi;
import de.imker.dto.AddressDto;
import de.imker.dto.NewAddressDto;
import de.imker.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddressController implements AddressApi {

  private final AddressService addressService;
  @Override
  public AddressDto getAddress() {
    return addressService.getAddress();
  }

  @Override
  public AddressDto updateAddress(NewAddressDto newAddress) {
    return addressService.updateAddress(newAddress);
  }
}
