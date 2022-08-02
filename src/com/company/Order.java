package com.company;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order {

    private LocalDateTime orderCreated;
    private Integer orderId;
    private List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "orderCreated=" + orderCreated +
                ", orderId=" + orderId +
                ", products=" + products +
                '}' + "\n";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order()
    {

    }
    public Order(String orderCreated, String orderId) {
        this.orderCreated = LocalDateTime.parse(orderCreated);
        this.orderId = Integer.parseInt(orderId);
        this.products = new ArrayList<>();

    }

    public Order(String orderCreated, String orderId, Product product) {
        this.orderCreated = LocalDateTime.parse(orderCreated);
        this.orderId = Integer.parseInt(orderId);
        this.products.add(product);
    }
    public Order(LocalDateTime orderCreated, Integer orderId, Product product) {
        this.orderCreated = orderCreated;
        this.orderId = orderId;
        this.products.add(product);
    }

    public LocalDateTime getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(LocalDateTime orderCreated) {
        this.orderCreated = orderCreated;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


}
