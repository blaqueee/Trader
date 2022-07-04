package com.Events;

import com.City;
import com.Trader;

public class NormalDay implements Usable{

    @Override
    public void doEvent(Trader trader, City city) {
        System.out.println("+----------------------------------------+\n" +
                           "|                USUAL DAY               |");
        System.out.printf(format, "NOTHING HAPPENED");
    }
}
