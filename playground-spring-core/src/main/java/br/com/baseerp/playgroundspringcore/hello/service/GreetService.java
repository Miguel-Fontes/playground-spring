package br.com.baseerp.playgroundspringcore.hello.service;

import br.com.baseerp.playgroundspringcore.hello.controller.GreetRequest;
import br.com.baseerp.playgroundspringcore.hello.controller.HelloResponse;
import br.com.baseerp.playgroundspringcore.hello.domain.model.Address;
import br.com.baseerp.playgroundspringcore.hello.domain.model.Person;
import br.com.baseerp.playgroundspringcore.hello.domain.repository.AddressRepository;
import br.com.baseerp.playgroundspringcore.hello.domain.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public GreetService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public HelloResponse greet(GreetRequest greetRequest) {
        Address address = new Address(
                "Rua guilherme",
                "123",
                "apto 222",
                "Costa e Silva",
                "Joinville",
                "Santa Catarina",
                "Brasil"
        );
        addressRepository.save(address);

        Person person = new Person(greetRequest.name(), address);
        personRepository.save(person);

        return new HelloResponse("Hello %s!".formatted(person.getName()));
    }

    public Person findByCity(String city) {
        return personRepository.findByAddress_City(city);
    }
}
