package br.com.baseerp.playgroundspringcore.hello.domain.repository;

import br.com.baseerp.playgroundspringcore.hello.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
