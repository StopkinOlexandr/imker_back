package de.imker.InitializationData;

import de.imker.models.Address;
import de.imker.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressInitialization {
  private final AddressRepository addressRepository;

  public void addressInit() {
    List<Address> addressList = addressRepository.findAll();
    if (addressList.size() == 0) {
      Address address = Address.builder()
          .address("29693 Eickeloh, Walsroder Str. 3")
          .phone("0516-290-12-66")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      addressRepository.save(address);
    }
  }
}
