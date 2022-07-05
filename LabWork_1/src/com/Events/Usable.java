package com.Events;

import com.City;
import com.Trader;

public interface Usable {
    String format = """
            +----------------------------------------+
            | %-38s |
            +----------------------------------------+
            """;
    void doEvent(Trader trader, City city);
    default void checkDistance(Trader trader, City city) {
        if (city.getDistanceToCity() - trader.getSpeed() > 0)
            city.setDistanceToCity(city.getDistanceToCity() - trader.getSpeed());
        else {
            System.out.println("\n  ===>  TRADER HAS ARRIVED TO " + city.getName() + "!  <===\n");
            city.setDistanceToCity(0);
        }
    }
}
