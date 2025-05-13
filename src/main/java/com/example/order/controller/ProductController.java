package com.example.order.controller;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

   @Autowired
   private ProductService productService;

   @PostMapping("/products")
   public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO){
       return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.CREATED);
   }


   @GetMapping("/product-details")
    public ResponseEntity<List<ProductDTO>> getAllProductDetails(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @GetMapping("/product-details/{id}")
    public ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductDetailsById(id),HttpStatus.OK);
    }


}
