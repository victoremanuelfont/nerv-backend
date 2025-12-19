package com.nerv.nervstore.dto;

import com.nerv.nervstore.entities.Order;
import com.nerv.nervstore.entities.OrderItem;
import com.nerv.nervstore.entities.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDTO {


    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Integer stockQuantity;


    private Set<OrderItem> items = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, String imgUrl, Double price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
        stockQuantity = entity.getStockQuantity();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Order> getOrders(){
        return items.stream().map(x -> x.getOrder()).toList();
    }
}
