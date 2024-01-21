package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ByteArrayOutputStream tempCaptor;

    @BeforeEach
    public void setUp() {
        tempCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempCaptor, true));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testAddSubscriptionInitiate() {
        String file = "sample_input/add_subscription_initiate.txt";
        String expected = "";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionInitiateInvalidDate() {
        String file = "sample_input/add_subscription_initiate_invalid_date.txt";
        String expected = "INVALID_DATE\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionInvalidDate() {
        String file = "sample_input/add_subscription_invalid_date.txt";
        String expected = "INVALID_DATE\n" +
                "ADD_SUBSCRIPTION_FAILED INVALID_DATE\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionDuplicateSubscriptions() {
        String file = "sample_input/add_subscription_duplicate_subscriptions.txt";
        String expected = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionWithoutTopup() {
        String file = "sample_input/add_subscription_without_topup.txt";
        String expected = "";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionWithTopup() {
        String file = "sample_input/add_subscription_with_topup.txt";
        String expected = "";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionDuplicateTopup() {
        String file = "sample_input/add_subscription_duplicate_topup.txt";
        String expected = "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionWithInvalidTopup() {
        String file = "sample_input/add_subscription_with_invalid_topup.txt";
        String expected = "INVALID ARGUMENTS\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

    @Test
    public void testAddSubscriptionWithTopupWithRenewalReminders() {
        String file = "sample_input/add_subscription_with_topup_with_renewal_reminders.txt";
        String expected = "RENEWAL_REMINDER MUSIC 23-02-2022\n" +
                "RENEWAL_REMINDER VIDEO 25-04-2022\n" +
                "RENEWAL_REMINDER PODCAST 23-02-2022\n" +
                "RENEWAL_AMOUNT 700\n";

        Main.main(new String[]{file});

        assertEquals(tempCaptor.toString(), expected);
    }

}