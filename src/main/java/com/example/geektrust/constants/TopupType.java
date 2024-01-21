package com.example.geektrust.constants;

public enum TopupType {
    FOUR_DEVICE(4),
    TEN_DEVICE(10);

    private final int devices;

    TopupType(int devices) {
        this.devices = devices;
    }

    public int getDevices() {
        return devices;
    }
}
