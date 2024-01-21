package com.example.geektrust.entities;

import com.example.geektrust.constants.SubscriptionCategory;

import java.time.LocalDate;

public interface Subscription {

    public Price getSubscriptionPrice();

    public int getDurationInMonths();

    public LocalDate getStartDate();

    public SubscriptionCategory getSubscriptionCategory();

}
