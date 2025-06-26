package br.com.baseerp.playgroundspringcore.hello.controller;

import br.com.baseerp.playgroundspringcore.hello.service.GreetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final GreetService greetService;

    public HelloController(GreetService greetService) {
        this.greetService = greetService;
    }

    @GetMapping
    public ResponseEntity<HelloResponse> sayHello() {
        return ResponseEntity.ok(new HelloResponse("Hello World!"));
    }

    @PostMapping
    public ResponseEntity<HelloResponse> sayHelloPost(
            @RequestBody GreetRequest greetRequest
    ) {
        return ResponseEntity.ok(greetService.greet(greetRequest));
    }

}
