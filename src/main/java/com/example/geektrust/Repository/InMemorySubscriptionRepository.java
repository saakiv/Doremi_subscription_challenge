package com.example.geektrust.Repository;

import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.entities.models.Topup;
import com.example.geektrust.exception.SubscriptionException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private static InMemorySubscriptionRepository instance;
    private final Map<SubscriptionCategory, Subscription> subscriptions = new LinkedHashMap<>();
    private Topup topup = null;

    private InMemorySubscriptionRepository() {
    }

    public static InMemorySubscriptionRepository getInstance() throws SubscriptionException {
        // If the instance is not created, create it
        if (instance == null) {
            instance = new InMemorySubscriptionRepository();
        }
        return instance;
    }

    public void resetSubscriptionRepository() {
        subscriptions.clear();
        topup = null;
    }

    @Override
    public boolean ifSubscriptionExists(SubscriptionCategory subscriptionCategory) {
        return subscriptions.containsKey(subscriptionCategory);
    }

    @Override
    public void addSubscription(SubscriptionCategory subscriptionCategory, Subscription subscription) {
        if (!subscriptions.containsKey(subscriptionCategory)) {
            subscriptions.put(subscriptionCategory, subscription);
        }
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptions.keySet().stream()
                .map(subscriptions::get)
                .collect(Collectors.toList());
    }

    @Override
    public boolean ifTopupExists() {
        return !(topup == null);
    }

    @Override
    public void addTopup(Topup topup) {
        this.topup = topup;
    }

    @Override
    public Topup getTopup() {
        return this.topup;
    }
}
