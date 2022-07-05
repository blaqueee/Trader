package com.Events;

import com.City;
import com.Trader;

public class River implements Usable{
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|           STOPPED ON A RIVER           |");
        System.out.printf(format, "LOOKING FOR A BRIDGE A WHOLE DAY");

        setSpeed(trader);
        checkDistance(trader, city);
    }

    public void setSpeed(Trader trader) {
        trader.setSpeed(0);
    }
}
