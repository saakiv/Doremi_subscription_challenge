package com.example.geektrust.Service;

import com.example.geektrust.Repository.InMemoryPlanRepository;
import com.example.geektrust.Repository.InMemorySubscriptionRepository;
import com.example.geektrust.Repository.InMemoryTopupRepository;
import com.example.geektrust.constants.Constants;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.exception.SubscriptionNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CLIRenewalNotificationService implements NotificationService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    InMemorySubscriptionRepository subscriptionRepository = InMemorySubscriptionRepository.getInstance();

    @Override
    public void printRenewalDetails() {

        int totalCost = 0;

        if (subscriptionRepository.getAllSubscriptions().isEmpty()) {
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }

        for (Subscription subscription : subscriptionRepository.getAllSubscriptions()) {

            LocalDate renewalDate = subscription.getStartDate()
                    .plusMonths(subscription.getDurationInMonths())
                    .minusDays(Constants.RENEWAL_NOTIFICATION_BUFFER);

            System.out.println("RENEWAL_REMINDER " + subscription.getSubscriptionCategory().getTag() + " " + renewalDate.format(DATE_FORMATTER));
            totalCost += subscription.getSubscriptionPrice().getUnits();
        }

        if (subscriptionRepository.ifTopupExists()) {
            totalCost += subscriptionRepository.getTopup().getPrice().getUnits() * subscriptionRepository.getTopup().getDurationInMonths();
        }

        System.out.println("RENEWAL_AMOUNT " + totalCost);
    }
}
