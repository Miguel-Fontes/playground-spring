package br.com.baseerp.playgroundspringcore.hello.domain.repository;

import br.com.baseerp.playgroundspringcore.hello.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
    Person findByAddress_City(String city);
}
