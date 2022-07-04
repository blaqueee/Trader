package com.Products;

public enum ProductType {

    // считаю продукты, представляя их в упаковках. А также покупаю и продаю в упаковках
    // цены указаны за упаковку

    MEAT("Meat", 5, 2000),
    DRIED_FRUITS("Dried fruits", 3, 500),
    CORN("Corn", 3, 450),
    FLOUR("Flour", 25, 5000),
    FABRICS("Fabrics", 1, 3000),
    DYE("Dye", 10, 1700);

    private String name;
    private int weight;
    private int price;
    ProductType(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
