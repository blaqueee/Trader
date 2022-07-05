package com.Events;

import com.City;
import com.Products.Product;
import com.Trader;
import com.Products.ProductState;
import java.util.ArrayList;
import java.util.Random;

public class Rain implements Usable{
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

    private boolean checkSpeed(Trader trader){
        return trader.getSpeed() - 2 >= trader.getMinSpeed();
    }

    private void spoilProduct(Trader trader){
        Random rnd = new Random();
        ProductState[] array = ProductState.values();
        int randomProduct = rnd.nextInt(trader.getProducts().size());

        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(trader.getProducts().get(randomProduct).getQuality()))
                index = i;
        }

        int chance = new Random().nextInt(100) + 1;


        if (chance <= 30) {
            if (index != array.length - 1) {
                ArrayList<Product> products = trader.getProducts();
                Product product = products.get(randomProduct);
                product.setQuality(array[index + 1]);
                products.set(randomProduct, product);
                trader.setProducts(products);

                String spoiled = String.format("%s KG OF %s BECAME %s", product.getWeight(), product.getName(), product.getQuality());
                System.out.printf(format, spoiled);
            }
        }

    }
}
