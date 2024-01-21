package com.example.geektrust.factory;

import com.example.geektrust.Repository.InMemoryPlanRepository;
import com.example.geektrust.constants.PlanType;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.entities.MusicSubscription;
import com.example.geektrust.entities.PodcastSubscription;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.entities.VideoSubscription;
import com.example.geektrust.factory.SubscriptionFactory;

import java.time.LocalDate;

public class PremiumSubscriptionFactory implements SubscriptionFactory {

    private static InMemoryPlanRepository planRepository;

    public PremiumSubscriptionFactory() {
        planRepository = InMemoryPlanRepository.getInstance();
    }

    public Subscription getSubscriptionPlan(SubscriptionCategory subscriptionCategory, LocalDate startDate) {
        switch (subscriptionCategory) {
            case MUSIC:
                return new MusicSubscription(planRepository.getPrice(subscriptionCategory, PlanType.PREMIUM),
                        planRepository.getDurationInMonths(subscriptionCategory, PlanType.PREMIUM),
                        startDate);
            case VIDEO:
                return new VideoSubscription(planRepository.getPrice(subscriptionCategory, PlanType.PREMIUM),
                        planRepository.getDurationInMonths(subscriptionCategory, PlanType.PREMIUM),
                        startDate);
            case PODCAST:
                return new PodcastSubscription(planRepository.getPrice(subscriptionCategory, PlanType.PREMIUM),
                        planRepository.getDurationInMonths(subscriptionCategory, PlanType.PREMIUM),
                        startDate);
            default:
                return null;
        }
    }
}
