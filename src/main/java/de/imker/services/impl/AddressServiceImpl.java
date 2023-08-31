package de.imker.services.impl;

import de.imker.dto.AddressDto;
import de.imker.dto.NewAddressDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Address;
import de.imker.repositories.AddressRepository;
import de.imker.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  @Override
  public AddressDto getAddress() {
    Address address = getAddressOrThrow();
    return AddressDto.from(address);
  }

  @Override
  public AddressDto updateAddress(NewAddressDto newLAddress) {
    Address address = getAddressOrThrow();

    address.setAddress(newLAddress.getAddress());
    address.setPhone(newLAddress.getPhone());
    address.setEmail(newLAddress.getEmail());

    addressRepository.save(address);

    return AddressDto.from(address);
  }

  private Address getAddressOrThrow() {
    return addressRepository.getAddressById(1L).orElseThrow(
        () -> new NotFoundException("Address not found"));
  }
}
