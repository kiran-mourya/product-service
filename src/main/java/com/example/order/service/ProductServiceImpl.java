package com.example.order.service;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = createProduct(productDTO);
        return productRepository.save(product);
    }


    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = createProductList(productList);
        return productDTOList;
    }

    @Override
    public ProductDTO getProductDetailsById(Integer id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = createProductFromProduct(product);
        return productDTO;
    }

    private List<ProductDTO> createProductList(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product pr: productList ) {
            ProductDTO product = new ProductDTO();
            product.setpId(pr.getpId());
            product.setPricing(pr.getPricing());
            product.setP_descriptions(pr.getP_descriptions());
            product.setSpecifications(pr.getSpecifications());
            product.setShipping_information(pr.getShipping_information());
            productDTOList.add(product);
        }
        return productDTOList;
    }
    private Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setpId(productDTO.getpId());
        product.setPricing(productDTO.getPricing());
        product.setP_descriptions(productDTO.getP_descriptions());
        product.setSpecifications(productDTO.getSpecifications());
        product.setShipping_information(productDTO.getShipping_information());
        return product;
    }
    private ProductDTO createProductFromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setpId(product.getpId());
        productDTO.setPricing(product.getPricing());
        productDTO.setP_descriptions(product.getP_descriptions());
        productDTO.setSpecifications(product.getSpecifications());
        productDTO.setShipping_information(product.getShipping_information());
        return productDTO;
    }
}
