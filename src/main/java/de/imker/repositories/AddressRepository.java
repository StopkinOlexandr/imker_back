package de.imker.repositories;

import de.imker.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
  Optional<Address> getAddressById(long id);

}
