package com.example.geektrust.constants;

public enum SubscriptionCategory {
    MUSIC("MUSIC"),
    VIDEO("VIDEO"),
    PODCAST("PODCAST");

    private final String tag;

    SubscriptionCategory(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }
}
