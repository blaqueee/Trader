package com.Events;

import com.City;
import com.Products.Product;
import com.Products.ProductState;
import com.Trader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadShop implements Usable {
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                "|            OH, ROADSIDE SHOP           |");

        if (checkMoney(trader)) {
            sellBadProduct(trader);
            trader.setMoney(trader.getMoney() - 500);
            System.out.printf(format, "PAID FOR HOTEL: 500 SOM");
        } else {
            System.out.printf(format, "NO MONEY LEFT, SO HE CAN'T STOP HERE");
            checkDistance(trader, city);
        }
    }

    private boolean checkMoney(Trader trader) {
        return trader.getMoney() >= 500;
    }

    private void sellBadProduct(Trader trader) {
        ArrayList<Product> products = trader.getProducts();
        int worstProduct = getTheWorstProduct(products);
        Product product = products.get(worstProduct);

        double finalPrice = product.getPrice() * product.getQuality().getCoefficient();
        trader.setMoney(trader.getMoney() + (int) finalPrice);
        products.set(worstProduct, getNormalProduct(product));

        String info = String.format("SOLD %s KG OF %s FOR %.0f SOM",
                product.getWeight(), product.getName(), finalPrice);
        String newInfo = String.format("BOUGHT %s KG OF %s FOR %s SOM",
                getNormalProduct(product).getWeight(), getNormalProduct(product).getName(), getNormalProduct(product).getPrice());
        System.out.printf(format, info);
        System.out.printf(format, newInfo);
    }

    private int getTheWorstProduct(ArrayList<Product> products) {
        List<Integer> stateIndexes = new ArrayList<>();
        List<ProductState> states = Arrays.asList(ProductState.values());

        for (int i = 0; i < products.size(); i++) {
            ProductState ps = products.get(i).getQuality();
            stateIndexes.add(states.indexOf(ps));
        }

        int bestQuality = getMaxValue(stateIndexes);

        return stateIndexes.indexOf(bestQuality);
    }

    private int getMaxValue(List<Integer> stateIndexes) {
        int max = stateIndexes.get(0);

        for (int x : stateIndexes) {
            if (max < x)
                max = x;
        }

        return max;
    }

    private Product getNormalProduct(Product product){
        product.setQuality(ProductState.NORMAL);
        return product;
    }
}
