package com.example.order;

import com.example.order.repository.ProductRepository;
import com.example.order.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ProductServiceApplicationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testMainMethodRunsWithoutException() {
        // Check that the application context is not null
        assertThat(applicationContext).isNotNull();
        assertDoesNotThrow(() -> ProductServiceApplication.main(new String[]{}));

        // Check that your beans are loaded
        assertThat(applicationContext.getBean(ProductService.class)).isNotNull();
        assertThat(applicationContext.getBean(ProductRepository.class)).isNotNull();

        System.out.println("✅ ApplicationContext loaded and beans are available");
    }
}
