package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
