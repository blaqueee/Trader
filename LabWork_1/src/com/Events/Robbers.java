package com.Events;

import com.City;
import com.Products.Product;
import com.Trader;
import com.Products.ProductState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robbers implements Usable{

    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|             OH, NO! ROBBERS!           |");
        ArrayList<Product> products = trader.getProducts();

        if (hasMoney(trader))
            giveAllMoney(trader);
        else
            giveTheBestProduct(products);

        trader.setProducts(products);
    }

    private void giveTheBestProduct(ArrayList<Product> products){
        int bestProductIndex = getTheBestProduct(products);
        String productStr = String.format("ROBBERS GOT %s KG OF %s", products.get(bestProductIndex).getWeight(), products.get(bestProductIndex).getName());
        System.out.printf(format, productStr);

        products.remove(bestProductIndex);
    }

    private boolean hasMoney(Trader trader){
        return trader.getMoney() > 0;
    }

    private void giveAllMoney(Trader trader){
        String moneyStr = String.format("ROBBERS GOT %s SOM", trader.getMoney());
        System.out.printf(format, moneyStr);
        trader.setMoney(0);
    }

    private int getTheBestProduct(ArrayList<Product> products){
        List<Integer> stateIndexes = new ArrayList<>();
        List<ProductState> states = Arrays.asList(ProductState.values());

        for (int i = 0; i < products.size(); i++){
            ProductState ps = products.get(i).getQuality();
            stateIndexes.add(states.indexOf(ps));
        }

        int bestQuality = getMinValue(stateIndexes);

        return stateIndexes.indexOf(bestQuality); // индекс лучшего продукта
    }

    private int getMinValue(List<Integer> indexes){
        int min = indexes.get(0);

        for (int i = 1; i < indexes.size(); i++){
            if (min > indexes.get(i))
                min = indexes.get(i);
        }

        return min;
    }
}
