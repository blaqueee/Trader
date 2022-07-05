package com.Events;

import com.City;
import com.Products.Product;
import com.Trader;

import java.util.ArrayList;
import java.util.Random;

public class Rain implements Usable {
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                "|              IT IS RAINING             |");
        System.out.printf(format, "SPEED -2");

        setSpeed(trader);
        checkDistance(trader, city);
        spoilProduct(trader);
    }

    public void setSpeed(Trader trader) {
        if (checkSpeed(trader))
            trader.setSpeed(trader.getSpeed() - 2);
        else
            trader.setSpeed(trader.getMinSpeed());
    }

    private boolean checkSpeed(Trader trader) {
        return trader.getSpeed() - 2 >= trader.getMinSpeed();
    }

    private void spoilProduct(Trader trader) {
        Random rnd = new Random();
        int randomProduct = rnd.nextInt(trader.getProducts().size());

        int chance = new Random().nextInt(100) + 1;

        if (chance <= 30) {
            ArrayList<Product> products = trader.getProducts();
            Product product = products.get(randomProduct);
            trader.spoilProduct(product);
            products.set(randomProduct, product);
            trader.setProducts(products);

            String spoiled = String.format("%s KG OF %s BECAME %s", product.getWeight(), product.getName(), product.getQuality());
            System.out.printf(format, spoiled);
        }

    }
}
