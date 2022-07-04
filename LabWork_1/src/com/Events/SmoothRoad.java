package com.Events;

import com.City;
import com.Trader;

public class SmoothRoad implements Usable {
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|            UHH, SMOOTH ROAD            |");
        System.out.printf(format, "SPEED +2");

        if (checkSpeed(trader))
            trader.setSpeed(trader.getSpeed() + 2);
        else
            trader.setSpeed(trader.getMaxSpeed());
    }

    private boolean checkSpeed(Trader trader){
        return trader.getSpeed() + 2 <= trader.getMaxSpeed();
    }
}
