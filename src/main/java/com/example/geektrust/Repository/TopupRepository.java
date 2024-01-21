package com.example.geektrust.Repository;

import com.example.geektrust.entities.Price;
import com.example.geektrust.constants.TopupType;

public interface TopupRepository {
    Price getPrice(TopupType topupType);

    int getDurationInMonths(TopupType topupType);

    public void addTopupDetails(TopupType topupType, int price, int durationInMonths);
}
