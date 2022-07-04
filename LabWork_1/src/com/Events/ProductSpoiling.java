package com.Events;

import com.City;
import com.Products.Product;
import com.Trader;
import com.Products.ProductState;

import java.util.ArrayList;
import java.util.Random;

public class ProductSpoiling implements Usable{
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|        PRODUCT HAS BEEN SPOILED        |");

        ArrayList<Product> products = trader.getProducts();
        int randomProductIndex = new Random().nextInt(products.size());

        Product product = products.get(randomProductIndex);
        spoilProduct(product);
        String spoiled = String.format("%s KG OF %s BECAME %s", product.getWeight(), product.getName(), product.getQuality());
        System.out.printf(format, spoiled);
        products.set(randomProductIndex, product);
        trader.setProducts(products);
    }

    public void spoilProduct(Product product){
        int index = getIndexOfState(product);
        ProductState[] states = ProductState.values();

        if (index != ProductState.values().length - 1)
            product.setQuality(states[index + 1]);
    }

    private int getIndexOfState(Product product){
        ProductState ps = product.getQuality();
        ProductState[] states = ProductState.values();
        int index = 0;
        for (int i = 0; i < states.length; i++){
            if (ps == states[i])
                index = i;
        }
        return index;
    }
}
