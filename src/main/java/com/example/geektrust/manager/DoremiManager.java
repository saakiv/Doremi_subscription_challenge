package com.example.geektrust.manager;

import com.example.geektrust.Repository.InMemoryPlanRepository;
import com.example.geektrust.Repository.InMemorySubscriptionRepository;
import com.example.geektrust.Repository.InMemoryTopupRepository;
import com.example.geektrust.Service.CLIRenewalNotificationService;
import com.example.geektrust.Service.CLISubscriptionService;
import com.example.geektrust.Service.EnrichmentService;
import com.example.geektrust.constants.Constants;
import com.example.geektrust.constants.PlanType;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.constants.TopupType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DoremiManager {

    public void run(String fileLocation) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));

            EnrichmentService enrichmentService = new EnrichmentService();
            enrichmentService.enrichPlans();
            enrichmentService.enrichTopups();

            CLISubscriptionService subscriptionService = new CLISubscriptionService();
            CLIRenewalNotificationService renewalNotificationService = new CLIRenewalNotificationService();

            String line = bufferedReader.readLine();
            List<String> commands;
            while (line != null) {
                commands = Arrays.asList(line.split(" "));
                try {
                    switch (commands.get(Constants.ZERO)) {

                        case "START_SUBSCRIPTION":
                            subscriptionService.startSubscription(commands.get(Constants.ONE));
                            break;
                        case "ADD_SUBSCRIPTION":
                            subscriptionService.addSubscription(SubscriptionCategory.valueOf(commands.get(Constants.ONE)), PlanType.valueOf(commands.get(Constants.TWO)));
                            break;
                        case "ADD_TOPUP":
                            subscriptionService.addTopup(TopupType.valueOf(commands.get(Constants.ONE)), Integer.parseInt(commands.get(Constants.TWO)));
                            break;
                        case "PRINT_RENEWAL_DETAILS":
                            renewalNotificationService.printRenewalDetails();
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("INVALID ARGUMENTS");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        flush();
    }

    public void flush() {
        InMemoryPlanRepository.getInstance().resetPlanRepository();
        InMemorySubscriptionRepository.getInstance().resetSubscriptionRepository();
        InMemoryTopupRepository.getInstance().resetTopupRepository();
    }
}
