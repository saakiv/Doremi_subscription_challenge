package com.example.geektrust;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.manager.DoremiManager;

public class Main {
    public static void main(String[] args) {
        DoremiManager doremiManager = new DoremiManager();
        doremiManager.run(args[Constants.ZERO]);
    }
}
