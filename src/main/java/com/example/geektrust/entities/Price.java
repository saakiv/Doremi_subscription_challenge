package com.example.geektrust.entities;

import com.example.geektrust.constants.Currency;

public class Price {
    private int units;
    private Currency currency;

    public Price(int units, Currency currency) {
        this.units = units;
        this.currency = currency;
    }

    public int getUnits() {
        return units;
    }

    public Currency getCurrency() {
        return currency;
    }
}
