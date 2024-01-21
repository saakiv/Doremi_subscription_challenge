package com.example.geektrust.Service;

import com.example.geektrust.Repository.InMemoryPlanRepository;
import com.example.geektrust.Repository.InMemoryTopupRepository;
import com.example.geektrust.Repository.PlanRepository;
import com.example.geektrust.Repository.TopupRepository;
import com.example.geektrust.constants.Constants;
import com.example.geektrust.constants.PlanType;
import com.example.geektrust.constants.SubscriptionCategory;
import com.example.geektrust.constants.TopupType;

public class EnrichmentService {

    PlanRepository planRepository = InMemoryPlanRepository.getInstance();
    TopupRepository topupRepository = InMemoryTopupRepository.getInstance();

    public void enrichPlans() {
        planRepository.addPlanDetails(SubscriptionCategory.MUSIC, PlanType.FREE, Constants.MUSIC_FREE_PLAN_PRICE, Constants.MUSIC_FREE_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.MUSIC, PlanType.PERSONAL, Constants.MUSIC_PERSONAL_PLAN_PRICE, Constants.MUSIC_PERSONAL_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.MUSIC, PlanType.PREMIUM, Constants.MUSIC_PREMIUM_PLAN_PRICE, Constants.MUSIC_PREMIUM_PLAN_VALIDITY);

        //video plans
        planRepository.addPlanDetails(SubscriptionCategory.VIDEO, PlanType.FREE, Constants.VIDEO_FREE_PLAN_PRICE, Constants.VIDEO_FREE_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.VIDEO, PlanType.PERSONAL, Constants.VIDEO_PERSONAL_PLAN_PRICE, Constants.VIDEO_PERSONAL_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.VIDEO, PlanType.PREMIUM, Constants.VIDEO_PREMIUM_PLAN_PRICE, Constants.VIDEO_PREMIUM_PLAN_VALIDITY);

        //podcast plans
        planRepository.addPlanDetails(SubscriptionCategory.PODCAST, PlanType.FREE, Constants.PODCAST_FREE_PLAN_PRICE, Constants.PODCAST_FREE_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.PODCAST, PlanType.PERSONAL, Constants.PODCAST_PERSONAL_PLAN_PRICE, Constants.PODCAST_PERSONAL_PLAN_VALIDITY);
        planRepository.addPlanDetails(SubscriptionCategory.PODCAST, PlanType.PREMIUM, Constants.PODCAST_PREMIUM_PLAN_PRICE, Constants.PODCAST_PREMIUM_PLAN_VALIDITY);

    }

    public void enrichTopups() {
        topupRepository.addTopupDetails(TopupType.FOUR_DEVICE, Constants.MONTHLY_FOUR_DEVICE_TOP_UP_PLAN_PRICE, 1);
        topupRepository.addTopupDetails(TopupType.TEN_DEVICE, Constants.MONTHLY_TEN_DEVICE_TOP_UP_PLAN_PRICE, 1);
    }
}
