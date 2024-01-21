package com.example.geektrust.factory;

import com.example.geektrust.constants.PlanType;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.entities.Subscription;

import java.time.LocalDate;

public interface SubscriptionFactory {
    abstract Subscription getSubscriptionPlan(SubscriptionCategory subscriptionCategory, LocalDate startDate);
}
