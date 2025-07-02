package br.com.baseerp.playgroundspringcore.hello.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {

    public static final String NEIGHTBORHOOD = "Costa e Silva";

    @Test
    void name() {
        Address address = new Address(
                "Rua guilherme",
                "123",
                "apto 222",
                NEIGHTBORHOOD,
                "Joinville",
                "Santa Catarina",
                "Brasil"
        );

        Assertions.assertEquals(NEIGHTBORHOOD, address.getNeighborhood());

        assertThrows(IllegalAccessException.class, () -> {
            throw new IllegalArgumentException();
        });

    }
}