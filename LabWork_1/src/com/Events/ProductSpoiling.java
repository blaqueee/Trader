package com.Events;

import com.City;
import com.Products.Product;
import com.Trader;

import java.util.ArrayList;
import java.util.Random;

public class ProductSpoiling implements Usable {
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                "|        PRODUCT HAS BEEN SPOILED        |");

        ArrayList<Product> products = trader.getProducts();
        int randomProductIndex = new Random().nextInt(products.size());

        Product product = products.get(randomProductIndex);
        trader.spoilProduct(product);
        String spoiled = String.format("%s KG OF %s BECAME %s", product.getWeight(), product.getName(), product.getQuality());
        System.out.printf(format, spoiled);
        products.set(randomProductIndex, product);
        trader.setProducts(products);
        checkDistance(trader, city);
    }
}
