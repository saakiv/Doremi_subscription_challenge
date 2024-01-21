package com.example.geektrust.dto;

import com.example.geektrust.entities.Price;

public class PlanDetails {
    Price price;
    int durationInMonths;

    public PlanDetails(Price price, int durationInMonths) {
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
