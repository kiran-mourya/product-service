package com.example.order.service;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProduct();

    ProductDTO getProductDetailsById(Integer id);
}
