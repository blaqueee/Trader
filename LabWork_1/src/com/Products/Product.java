package com.Products;

public class Product {
    private int weight;
    private ProductType type;
    private String name;
    private ProductState quality;
    private int price;

    public Product(ProductType type) {
        this.type = type;
        this.name = type.getName();
        this.price = type.getPrice();
        this.weight = type.getWeight();
        this.quality = ProductState.NORMAL;
    }

    public void setQuality(ProductState quality) {
        this.quality = quality;
    }

    public ProductState getQuality() {
        return quality;
    }

    public int getWeight() {
        return weight;
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
