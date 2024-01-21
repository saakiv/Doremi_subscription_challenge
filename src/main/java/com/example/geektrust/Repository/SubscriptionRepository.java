package com.example.geektrust.Repository;

import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.entities.models.Topup;

import java.util.List;

public interface SubscriptionRepository {

    public boolean ifSubscriptionExists(SubscriptionCategory subscriptionCategory);

    public void addSubscription(SubscriptionCategory subscriptionCategory, Subscription subscription);

    public List<Subscription> getAllSubscriptions();

    public boolean ifTopupExists();

    public void addTopup(Topup topup);

    public Topup getTopup();

}
