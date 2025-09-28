package com.example.order;

import com.example.order.controller.ProductController;
import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers=ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductServiceImpl productService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductDTO getSampleProductDTO() {
        ProductDTO dto = new ProductDTO();
        dto.setpId(1);
        dto.setPricing("100.0");
        dto.setP_descriptions("Sample product");
        dto.setSpecifications("Specs");
        dto.setShipping_information("Ships in 2 days");
        return dto;
    }

    private Product getSampleProduct() {
        Product product = new Product();
        product.setpId(1);
        product.setPricing("100.0");
        product.setP_descriptions("Sample product");
        product.setSpecifications("Specs");
        product.setShipping_information("Ships in 2 days");
        return product;
    }

    @Test
    void testSaveProduct_returnsCreated() throws Exception {
        Product product = getSampleProduct();
        ProductDTO dto = getSampleProductDTO();

        when(productService.saveProduct(any(ProductDTO.class))).thenReturn(product);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetAllProductDetails_returnsList() throws Exception {
        List<ProductDTO> productList = Collections.singletonList(getSampleProductDTO());

        when(productService.getAllProduct()).thenReturn(productList);

        String responseBody = mockMvc.perform(get("/product-details"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ProductDTO[] responseArray = objectMapper.readValue(responseBody, ProductDTO[].class);

        assertEquals(1, responseArray.length);
        assertEquals(productList.get(0).getpId(), responseArray[0].getpId());
    }

    @Test
    void testGetProductDetailsById_returnsProduct() throws Exception {
        ProductDTO dto = getSampleProductDTO();

        when(productService.getProductDetailsById(1)).thenReturn(dto);

        String responseBody = mockMvc.perform(get("/product-details/1"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ProductDTO responseDTO = objectMapper.readValue(responseBody, ProductDTO.class);

        assertEquals(dto.getpId(), responseDTO.getpId());
        assertEquals(dto.getPricing(), responseDTO.getPricing());
    }
/*
    @Test
    @Disabled("ignored for now")
    void testGetProductDetailsById_notFound() throws Exception {
        when(productService.getProductDetailsById(99))
                .thenThrow(new NoSuchElementException("Product not found"));

        int status = mockMvc.perform(get("/product-details/99"))
                .andReturn()
                .getResponse()
                .getStatus();

        assertEquals(404, status); // adjust if you implement exception handler
    }*/
}

