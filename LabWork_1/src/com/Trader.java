package com;

import com.Products.Product;
import com.Products.ProductType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Trader {
    private ArrayList<Product> products = new ArrayList<>();
    private int maxWeightCapacity;
    private int weight = 0;
    private int maxSpeed = 5;
    private int minSpeed = 1;
    private int speed;
    private int initialMoney;
    private int money;

    public Trader(int weightCapacity, int speed, int initialMoney) {
        this.maxWeightCapacity = weightCapacity;
        this.speed = speed;
        this.initialMoney = initialMoney;
        this.money = initialMoney;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void spoilProduct(Product product){
        product.getQuality().spoilProduct(product);
    }

    public void sortProducts(){
        Comparator<Product> cmp = Comparator.comparing(Product::getName);

        products.sort(cmp);
    }

    public void setNormalSpeed(){
        this.speed = 3;
    }

    public void buyInitialProducts() {
        ProductType[] productArray = ProductType.values();
        System.out.println("""
                      ===> TRADER'S SHOPPING <===
                +---------------+----------+-------------+
                |    PRODUCT    |  WEIGHT  |    PRICE    |
                +---------------+----------+-------------+""");
        int counter = 0;
        while (true) {
            Product product = new Product(productArray[new Random().nextInt(productArray.length)]);
            if (checkMoney(product.getPrice()) && checkWeight(product.getWeight())) {
                products.add(product);
                money -= product.getPrice();
                weight += product.getWeight();
                System.out.printf("| %-13s | %-8s | %-11s |%n" +
                        "+---------------+----------+-------------+%n", product.getName(), product.getWeight(), product.getPrice());
            } else if (!checkMoney(product.getPrice())) {
                counter ++;
                if (counter >= 10) {
                    System.out.println("         ===> NO MONEY LEFT <=== \n");
                    return;
                }
            } else {
                counter ++;
                if (counter >= 10) {
                    System.out.println(" -CAN'T FIT MORE PRODUCTS, WEIGHT'S FULL-\n");
                    return;
                }
            }
        }
    }

    public void printProducts() {
        System.out.println("+---------------+--------------------+");
        System.out.println("|    PRODUCT    |       QUALITY      |");
        System.out.println("+---------------+--------------------+");
        for (Product product : products) {
            System.out.printf("| %-13s | %-18s |%n", product.getName(), product.getQuality());
            System.out.println("+---------------+--------------------+");
        }

        if (products.size() == 0) {
            System.out.println("|          NO PRODUCTS LEFT          |");
            System.out.println("+------------------------------------+");
        }
    }

    public void sellProducts() {
        System.out.println("""
                                  ===> TRADER IS SELLING <===
                +---------------+----------+--------------------+-------------+
                |    PRODUCT    |  WEIGHT  |       QUALITY      |    PRICE    |
                +---------------+----------+--------------------+-------------+""");
        for (Product product : products) {
            System.out.printf("| %-13s | %-8s | %-18s | %-11.0f |%n" +
                            "+---------------+----------+--------------------+-------------+%n",
                    product.getName(), product.getWeight(), product.getQuality(), product.getPrice() * product.getQuality().getCoefficient());
            money += product.getPrice() * product.getQuality().getCoefficient();
        }

        printResults();
    }

    private void printResults() {
        int difference = money - initialMoney;
        System.out.println("""
                                ===> RESULT <===
                +---------------+---------------+---------------+
                | INITIAL MONEY |  FINAL MONEY  |  DIFFERENCE   |
                +---------------+---------------+---------------+""");
        System.out.printf("| %-13s | %-13s | %-13s |%n", initialMoney, money, difference);
        System.out.println("+---------------+---------------+---------------+");

        if (difference > 0)
            System.out.println("          ===> TRADER IS IN PROFIT! <===");
        else if (difference < 0)
            System.out.println("           ===> TRADER IS AT LOSS! <===");
        else
            System.out.println("    ===> TRADER HAS NO PROFIT AND NO LOSS <===");
    }

    private boolean checkMoney(int productPrice) {
        return money - productPrice >= 0;
    }

    private boolean checkWeight(int productWeight) {
        return weight + productWeight <= maxWeightCapacity;
    }
}
