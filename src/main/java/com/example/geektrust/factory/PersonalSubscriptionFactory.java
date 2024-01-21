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

public class PersonalSubscriptionFactory implements SubscriptionFactory {

    private static InMemoryPlanRepository planRepository;

    public PersonalSubscriptionFactory() {
        planRepository = InMemoryPlanRepository.getInstance();
    }

    public Subscription getSubscriptionPlan(SubscriptionCategory subscriptionCategory, LocalDate startDate) {
        switch (subscriptionCategory) {
            case MUSIC:
                return new MusicSubscription(planRepository.getPrice(subscriptionCategory,
                        PlanType.PERSONAL), planRepository.getDurationInMonths(subscriptionCategory, PlanType.PERSONAL),
                        startDate);
            case VIDEO:
                return new VideoSubscription(planRepository.getPrice(subscriptionCategory,
                        PlanType.PERSONAL), planRepository.getDurationInMonths(subscriptionCategory, PlanType.PERSONAL),
                        startDate);
            case PODCAST:
                return new PodcastSubscription(planRepository.getPrice(subscriptionCategory,
                        PlanType.PERSONAL), planRepository.getDurationInMonths(subscriptionCategory, PlanType.PERSONAL),
                        startDate);
            default:
                return null;
        }
    }
}
