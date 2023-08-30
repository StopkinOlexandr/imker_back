package de.imker.services;

import de.imker.dto.AddressDto;
import de.imker.dto.NewAddressDto;

public interface AddressService {

  AddressDto getAddress();

  AddressDto updateAddress(NewAddressDto newLAddress);

}
