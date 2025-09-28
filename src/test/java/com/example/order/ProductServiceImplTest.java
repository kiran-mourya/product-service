package com.example.order;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.repository.ProductRepository;
import com.example.order.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        product.setpId(1);
        product.setPricing("100.0");
        product.setP_descriptions("Sample product");
        product.setSpecifications("Specs");
        product.setShipping_information("Ships in 2 days");

        productDTO = new ProductDTO();
        productDTO.setpId(1);
        productDTO.setPricing("100.0");
        productDTO.setP_descriptions("Sample product");
        productDTO.setSpecifications("Specs");
        productDTO.setShipping_information("Ships in 2 days");
    }

    @Test
    void testSaveProduct_success() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product saved = productService.saveProduct(productDTO);

        assertNotNull(saved);
        assertEquals(product.getpId(), saved.getpId());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testGetAllProduct_returnsList() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);

        List<ProductDTO> result = productService.getAllProduct();

        assertEquals(1, result.size());
        assertEquals(product.getpId(), result.get(0).getpId());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetAllProduct_emptyList() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<ProductDTO> result = productService.getAllProduct();

        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductDetailsById_found() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        ProductDTO result = productService.getProductDetailsById(1);

        assertNotNull(result);
        assertEquals(product.getpId(), result.getpId());
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testGetProductDetailsById_notFound_throwsException() {
        when(productRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> productService.getProductDetailsById(2));
        verify(productRepository, times(1)).findById(2);
    }

    @Test
    void testSaveProduct_nullInput_throwsException() {
        assertThrows(NullPointerException.class, () -> productService.saveProduct(null));
    }
}