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
}
