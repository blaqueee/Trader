package com;

import com.Events.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        Trader trader = new Trader(50, 3, 20000);
        City city = getRandomCity();

        printInitialInfo(trader.getMoney(), city.getName());

        ArrayList<Usable> events = initializeEvents();
        trader.buyInitialProducts();
        trader.sortProducts();

        int dayCounter = 1;

        while (city.getDistanceToCity() != 0) {
            Collections.shuffle(events);
            System.out.print("       <- Tap ENTER to continue ->");
            String str = new Scanner(System.in).nextLine();
            System.out.printf("%n             <=== DAY %s ===>%n", dayCounter);

            Usable event = events.get(0);
            event.doEvent(trader, city);

            if (!event.getClass().equals(BrokenWheel.class) && !event.getClass().equals(River.class)) {
                trader.startMovingToCity(city);
            }
            if (city.getDistanceToCity() != 0) {
                System.out.printf("DISTANCE LEFT: %s%n%n", city.getDistanceToCity());
            }
            if (trader.getProducts().size() == 0) {
                trader.printProducts();
                System.out.println("    ---> TRADER LOST THE GAME <---");
                return;
            }
            trader.setNormalSpeed();
            dayCounter++;
//            trader.printProducts();  //можете удалить комментарий, чтобы каждый день видеть состояние продуктов
        }

        trader.sellProducts();
    }

    private static City getRandomCity() {
        Random rnd = new Random();
        City[] citiesArray = {
                new City("Hallstatt", rnd.nextInt(50, 101)),
                new City("Naryn", rnd.nextInt(50, 101)),
                new City("Berlin", rnd.nextInt(50, 101)),
                new City("Cappadocia", rnd.nextInt(50, 101)),
                new City("Bishkek", rnd.nextInt(50, 101)),
        };
        List<City> cities = Arrays.asList(citiesArray);
        Collections.shuffle(cities);
        return cities.get(rnd.nextInt(cities.size()));
    }

    private static ArrayList<Usable> initializeEvents() {
        ArrayList<Usable> events = new ArrayList<>();
        events.add(new NormalDay());
        events.add(new Rain());
        events.add(new SmoothRoad());
        events.add(new BrokenWheel());
        events.add(new River());
        events.add(new MeetLocal());
        events.add(new Robbers());
        events.add(new ProductSpoiling());

        return events;
    }

    private static void printInitialInfo(int money, String name) {
        System.out.printf("+---------------------+---------------+%n" +
                "|    INITIAL MONEY    |    TO CITY    |%n" +
                "+---------------------+---------------+%n" +
                "| %-19s | %-13s |%n" +
                "+---------------------+---------------+%n", money, name);
    }
}
