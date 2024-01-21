package com.example.geektrust.entities.models;

import com.example.geektrust.entities.Price;
import com.example.geektrust.constants.TopupType;

import java.time.LocalDate;

public class Topup {

    TopupType topupType;
    int noOfDevice;
    Price price;
    int durationInMonths;
    LocalDate startDate;

    public Topup(TopupType topupType, Price price, int durationInMonths, LocalDate startDate) {
        this.topupType = topupType;
        this.noOfDevice = topupType.getDevices();
        this.price = price;
        this.durationInMonths = durationInMonths;
        this.startDate = startDate;
    }

    public TopupType getTopupType() {
        return topupType;
    }

    public int getNoOfDevice() {
        return noOfDevice;
    }

    public Price getPrice() {
        return price;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
