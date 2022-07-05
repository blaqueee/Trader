package com.Events;

import com.City;
import com.Trader;

import java.util.Random;

public class MeetLocal implements Usable{
    @Override
    public void doEvent(Trader trader, City city) {
        int randomDistance = new Random().nextInt(4) + 3; // от 3 - 6 (включительно)
        System.out.println("+----------------------------------------+\n" +
                           "|      TRADER MEETS A LOCAL CITIZEN      |");
        String distance = String.format("MANGED TO TAKE A SHORTCUT: %s KM", randomDistance);
        System.out.printf(format, distance);

        city.setDistanceToCity(city.getDistanceToCity() - randomDistance);
        checkDistance(trader, city);
    }
}
