package com.example.geektrust.entities;

import com.example.geektrust.constants.SubscriptionCategory;

import java.time.LocalDate;

public class VideoSubscription implements Subscription {
    public static final SubscriptionCategory subscriptionCategory = SubscriptionCategory.VIDEO;

    protected Price subscriptionPrice;
    protected int durationInMonths;
    protected LocalDate startDate;

    public VideoSubscription(Price subscriptionPrice, int duration, LocalDate startDate) {
        super();
        this.subscriptionPrice = subscriptionPrice;
        this.durationInMonths = duration;
        this.startDate = startDate;
    }

    @Override
    public Price getSubscriptionPrice() {
        return this.subscriptionPrice;
    }

    @Override
    public int getDurationInMonths() {
        return durationInMonths;
    }

    @Override
    public LocalDate getStartDate() {
        return this.startDate;
    }

    @Override
    public SubscriptionCategory getSubscriptionCategory() {
        return subscriptionCategory;
    }

}
