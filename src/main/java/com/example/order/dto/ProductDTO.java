package com.example.order.dto;

import java.util.Objects;

public class ProductDTO {
    private Integer pId;
    private String p_descriptions;
    private String specifications;
    private String pricing;
    private String shipping_information;
    private Integer quantity;
    public ProductDTO(){}
    public ProductDTO(Integer pId, String p_descriptions, String specifications, String pricing, String shipping_information,Integer quantity) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(pId, that.pId) && Objects.equals(p_descriptions, that.p_descriptions) && Objects.equals(specifications, that.specifications) && Objects.equals(pricing, that.pricing) && Objects.equals(shipping_information, that.shipping_information) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, p_descriptions, specifications, pricing, shipping_information, quantity);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "pId=" + pId +
                ", p_descriptions='" + p_descriptions + '\'' +
                ", specifications='" + specifications + '\'' +
                ", pricing='" + pricing + '\'' +
                ", shipping_information='" + shipping_information + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
