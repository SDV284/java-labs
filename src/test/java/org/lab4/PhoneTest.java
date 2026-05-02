package org.lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Phone phone = new Phone("Valid", "Valid", 100, 3000);
        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-50); // Від'ємна ціна
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Model", 1000, 4000); // Порожній бренд
        });
    }
}