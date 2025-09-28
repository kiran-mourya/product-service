package com.example.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ProductServiceApplicationTest {
    @Test
    void testMainMethodRunsWithoutException() {
        assertDoesNotThrow(() -> ProductServiceApplication.main(new String[]{}));
    }
}
