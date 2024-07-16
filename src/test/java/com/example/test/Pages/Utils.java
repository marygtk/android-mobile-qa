package com.example.test.Pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import java.time.Duration;
import java.util.Arrays;

public class Utils {

    public static void swipeLeftMethod(AppiumDriver driver, WebElement webElement) {
        // Calculate swipe start and end points
        int startX = 630; //
        int startY = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);
        int endX = 30;
        int endY = startY;

        // Create a PointerInput instance for touch actions
        PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

        // Create a swipe sequence
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the swipe action
        driver.perform(Arrays.asList(swipe));
    }

    public static void swipeUpMethod(AppiumDriver driver, WebElement webElement) {
        // Calculate swipe start and end points
        int startX = 536; // Middle X point
        int startY = webElement.getLocation().getY();
        System.out.print(startY);// Start point Y (75% from the top)
        int endX = startX; // Swipe on the same X level
        int endY = 458; // End point Y (25% from the top)

        // Create a PointerInput instance for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create a swipe sequence
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) // Touch down
                .addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), endX, endY)) // Move up
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Touch up

        // Perform the swipe action
        driver.perform(Arrays.asList(swipe));
    }

    public static void swipeDownMethod(AppiumDriver driver, WebElement webElement) {
        // Calculate swipe start and end points
        int startX = 458;
        int startY = webElement.getLocation().getY();
        int endX = startX;
        int endY = 580;

        // Create a PointerInput instance for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create a swipe sequence
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) // Touch down
                .addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), endX, endY)) // Move up
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Touch up

        // Perform the swipe action
        driver.perform(Arrays.asList(swipe));
    }
}
