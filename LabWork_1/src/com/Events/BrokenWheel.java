package com.Events;

import com.City;
import com.Trader;

public class BrokenWheel implements Usable{
    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|               BROKEN WHEEL             |");
        System.out.printf(format, "REPAIRING WHEEL A WHOLE DAY");
        setSpeed(trader);
        checkDistance(trader, city);
    }

    private void setSpeed(Trader trader) {
        trader.setSpeed(0);
    }
}
