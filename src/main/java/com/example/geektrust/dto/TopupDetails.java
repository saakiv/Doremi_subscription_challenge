package com.example.geektrust.dto;

import com.example.geektrust.entities.Price;

public class TopupDetails {
    Price price;
    int durationInMonths;

    public TopupDetails(Price price, int durationInMonths) {
        this.price = price;
        this.durationInMonths = durationInMonths;
    }

    public Price getPrice() {
        return price;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }
}
