package com.company;

public class Product {
    private String description;
    private String gtin;
    private String currency;
    private Float price;
    private String supplier;
    private Integer orderId;

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", gtin='" + gtin + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                '}';
    }

    public Product()
    {

    }
    public Product(String description, String gtin, String currency, Float price, String supplier) {
        this.description = description;
        this.gtin = gtin;
        this.currency = currency;
        this.price = price;
        this.supplier = supplier;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
