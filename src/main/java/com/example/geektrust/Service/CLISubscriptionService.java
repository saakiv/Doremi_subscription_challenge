package com.example.geektrust.Service;

import com.example.geektrust.Repository.InMemoryPlanRepository;
import com.example.geektrust.Repository.InMemorySubscriptionRepository;
import com.example.geektrust.Repository.InMemoryTopupRepository;
import com.example.geektrust.constants.PlanType;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.constants.TopupType;
import com.example.geektrust.entities.*;
import com.example.geektrust.entities.models.Topup;
import com.example.geektrust.exception.*;
import com.example.geektrust.factory.FreeSubscriptionFactory;
import com.example.geektrust.factory.PersonalSubscriptionFactory;
import com.example.geektrust.factory.PremiumSubscriptionFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CLISubscriptionService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    InMemoryTopupRepository topupRepository = InMemoryTopupRepository.getInstance();
    InMemorySubscriptionRepository subscriptionRepository = InMemorySubscriptionRepository.getInstance();
    private LocalDate subscriptionStartDate = null;

    private Subscription getSubscription(SubscriptionCategory subscriptionCategory, PlanType planType) throws SubscriptionException {
        switch (planType) {
            case FREE: {
                return new FreeSubscriptionFactory().getSubscriptionPlan(subscriptionCategory, subscriptionStartDate);
            }
            case PERSONAL: {
                return new PersonalSubscriptionFactory().getSubscriptionPlan(subscriptionCategory, subscriptionStartDate);
            }
            case PREMIUM: {
                return new PremiumSubscriptionFactory().getSubscriptionPlan(subscriptionCategory, subscriptionStartDate);
            }
            default:
                throw new SubscriptionInvalidTypeException("INVALID_SUBSCRIPTION_CATEGORY");
        }
    }

    public void startSubscription(String date) throws Exception {
        try {
            subscriptionStartDate = LocalDate.parse(date, DATE_FORMATTER);
        } catch (Exception e) {
            throw new InvalidDateException("INVALID_DATE");
        }
    }

    public void addSubscription(SubscriptionCategory subscriptionCategory, PlanType planType) throws SubscriptionException {

        if (subscriptionStartDate == null) {
            throw new AddSubscriptionFailedException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        } else if (!subscriptionRepository.ifSubscriptionExists(subscriptionCategory)) {
            subscriptionRepository.addSubscription(subscriptionCategory, getSubscription(subscriptionCategory, planType));
        } else {
            throw new AddSubscriptionFailedException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        }

    }

    public void addTopup(TopupType topupType, int durationInMonths) throws TopupException {
        if (subscriptionStartDate == null) {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED INVALID_DATE");
        } else if (subscriptionRepository.getAllSubscriptions().isEmpty()) {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
        }

        if (!subscriptionRepository.ifTopupExists()) {
            subscriptionRepository.addTopup(new Topup(topupType, topupRepository.getPrice(topupType), durationInMonths, subscriptionStartDate));
        } else {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
    }


}
