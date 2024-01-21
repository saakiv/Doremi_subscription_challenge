package com.example.geektrust.Repository;

import com.example.geektrust.dto.PlanDetails;
import com.example.geektrust.constants.Currency;
import com.example.geektrust.constants.PlanType;
import com.example.geektrust.entities.Price;
import com.example.geektrust.constants.SubscriptionCategory;

import java.util.HashMap;


public class InMemoryPlanRepository implements PlanRepository {

    private static InMemoryPlanRepository instance;
    private final HashMap<PlanType, PlanDetails> musicRepository = new HashMap<>();
    private final HashMap<PlanType, PlanDetails> videoRepository = new HashMap<>();
    private final HashMap<PlanType, PlanDetails> podcastRepository = new HashMap<>();

    private InMemoryPlanRepository() {
    }

    public static InMemoryPlanRepository getInstance() {
        // If the instance is not created, create it
        if (instance == null) {
            instance = new InMemoryPlanRepository();
        }
        return instance;
    }

    public void resetPlanRepository() {
        musicRepository.clear();
        videoRepository.clear();
        podcastRepository.clear();
    }

    @Override
    public Price getPrice(SubscriptionCategory subscriptionCategory, PlanType planType) {
        switch (subscriptionCategory) {
            case MUSIC: {
                return musicRepository.get(planType).getPrice();
            }
            case VIDEO: {
                return videoRepository.get(planType).getPrice();
            }
            case PODCAST: {
                return podcastRepository.get(planType).getPrice();
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public int getDurationInMonths(SubscriptionCategory subscriptionCategory, PlanType planType) {
        switch (subscriptionCategory) {
            case MUSIC: {
                return musicRepository.get(planType).getDurationInMonths();
            }
            case VIDEO: {
                return videoRepository.get(planType).getDurationInMonths();
            }
            case PODCAST: {
                return podcastRepository.get(planType).getDurationInMonths();
            }
            default: {
                return 0;
            }
        }
    }

    @Override
    public void addPlanDetails(SubscriptionCategory subscriptionCategory, PlanType planType, int price, int durationInMonths) {
        switch (subscriptionCategory) {
            case MUSIC: {
                musicRepository.put(planType, new PlanDetails(new Price(price, Currency.INR), durationInMonths));
            }
            case VIDEO: {
                videoRepository.put(planType, new PlanDetails(new Price(price, Currency.INR), durationInMonths));
            }
            case PODCAST: {
                podcastRepository.put(planType, new PlanDetails(new Price(price, Currency.INR), durationInMonths));
            }
        }
    }

}
