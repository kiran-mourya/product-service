/*
package com.example.order;

import com.example.order.entity.Product;
import com.example.order.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setpId(1);
        product.setP_descriptions("Sample Product");
        product.setPricing("100.0");
        product.setSpecifications("Specs");
        product.setShipping_information("Ships in 2 days");
        productRepository.save(product);
    }

    @Test
    @Disabled
    void testSaveProduct() {
        Product saved = productRepository.save(product);
        assertThat(saved).isNotNull();
        assertThat(saved.getpId()).isEqualTo(product.getpId());
    }

    @Test
    @Disabled
    void testFindById_exists() {
        Optional<Product> found = productRepository.findById(product.getpId());
        assertTrue(found.isPresent());
        assertThat(found.get().getP_descriptions()).isEqualTo("Sample Product");
    }

   */
/* @Test
    @Disabled
    void testFindById_notExists() {
        Optional<Product> found = productRepository.findById(999);
        assertThat(found).isEmpty();
    }
*//*

    @Test
    @Disabled
    void testFindByDescription_exists() {
        Optional<Product> found = productRepository.findByP_descriptions("Sample Product");
        assertTrue(found.isPresent());
        assertThat(found.get().getPricing()).isEqualTo("100.0");
    }

    @Test
    @Disabled
    void testFindByDescription_notExists() {
        Optional<Product> found = productRepository.findByP_descriptions("Non Existing");
        assertThat(found).isEmpty();
    }

    @Test
    @Disabled
    void testDeleteProduct() {
        productRepository.delete(product);
        Optional<Product> deleted = productRepository.findById(product.getpId());
        assertThat(deleted).isEmpty();
    }
}
*/
