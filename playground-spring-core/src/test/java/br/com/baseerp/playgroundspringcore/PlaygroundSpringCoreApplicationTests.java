package br.com.baseerp.playgroundspringcore;

import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.baseerp.playgroundspringcore.hello.controller.GreetRequest;
import br.com.baseerp.playgroundspringcore.hello.controller.HelloResponse;
import br.com.baseerp.playgroundspringcore.hello.service.GreetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundSpringCoreApplicationTests {

    private GreetService service;

    @Autowired
    PlaygroundSpringCoreApplicationTests(GreetService service) {
        this.service = service;
    }

    @Test
    void contextLoads() {
        String name = "Miguel Fontes";
        HelloResponse miguelFontes = service.greet(new GreetRequest(name));

        assertTrue(miguelFontes.message().contains(name));
    }

}
