package com.example.geektrust.Repository;

import com.example.geektrust.dto.TopupDetails;
import com.example.geektrust.constants.Currency;
import com.example.geektrust.entities.Price;
import com.example.geektrust.constants.TopupType;

import java.util.HashMap;

public class InMemoryTopupRepository implements TopupRepository {
    private static InMemoryTopupRepository instance;
    public final HashMap<TopupType, TopupDetails> topupRepository = new HashMap<>();

    private InMemoryTopupRepository() {
    }

    public static InMemoryTopupRepository getInstance() {
        // If the instance is not created, create it
        if (instance == null) {
            instance = new InMemoryTopupRepository();
        }
        return instance;
    }

    public void resetTopupRepository() {
        topupRepository.clear();
    }

    @Override
    public Price getPrice(TopupType topupType) {
        return topupRepository.get(topupType).getPrice();
    }

    @Override
    public int getDurationInMonths(TopupType topupType) {
        return topupRepository.get(topupType).getDurationInMonths();
    }

    @Override
    public void addTopupDetails(TopupType topupType, int price, int durationInMonths) {
        topupRepository.put(topupType, new TopupDetails(new Price(price, Currency.INR), durationInMonths));
    }
}
