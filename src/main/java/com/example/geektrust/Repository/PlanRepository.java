package com.example.geektrust.Repository;

import com.example.geektrust.constants.PlanType;
import com.example.geektrust.entities.Price;
import com.example.geektrust.constants.SubscriptionCategory;

public interface PlanRepository {
    Price getPrice(SubscriptionCategory subscriptionCategory, PlanType planType);

    int getDurationInMonths(SubscriptionCategory subscriptionCategory, PlanType planType);

    public void addPlanDetails(SubscriptionCategory subscriptionCategory, PlanType planType, int price, int durationInMonths);

}
