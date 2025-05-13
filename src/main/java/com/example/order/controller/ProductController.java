package com.example.order.controller;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

   @Autowired
   private ProductService productService;

   @PostMapping("/products")
   public Product saveProduct(@RequestBody ProductDTO productDTO){
       return productService.saveProduct(productDTO);
   }


   @GetMapping("/product-details")
    public List<ProductDTO> getAllProductDetails(){
        return productService.getAllProduct();
    }

    @GetMapping("/product-details/{id}")
    public ProductDTO getProductDetailsById(@PathVariable Integer id){
        return productService.getProductDetailsById(id);
    }


}
