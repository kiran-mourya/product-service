package com.example.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Product {
    @Id
    private Integer pId;
    private String p_descriptions;
    private String specifications;
    private String pricing;
    private String shipping_information;
    private Integer quantity;

    public Product(){}

    public Product(Integer pId, String p_descriptions, String specifications, String pricing, String shipping_information,Integer quantity ) {
        this.pId = pId;
        this.p_descriptions = p_descriptions;
        this.specifications = specifications;
        this.pricing = pricing;
        this.shipping_information = shipping_information;
        this.quantity = quantity;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getP_descriptions() {
        return p_descriptions;
    }

    public void setP_descriptions(String p_descriptions) {
        this.p_descriptions = p_descriptions;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getShipping_information() {
        return shipping_information;
    }

    public void setShipping_information(String shipping_information) {
        this.shipping_information = shipping_information;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", p_descriptions='" + p_descriptions + '\'' +
                ", specifications='" + specifications + '\'' +
                ", pricing='" + pricing + '\'' +
                ", shipping_information='" + shipping_information + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(pId, product.pId) && Objects.equals(p_descriptions, product.p_descriptions) && Objects.equals(specifications, product.specifications) && Objects.equals(pricing, product.pricing) && Objects.equals(shipping_information, product.shipping_information) && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, p_descriptions, specifications, pricing, shipping_information, quantity);
    }
}
