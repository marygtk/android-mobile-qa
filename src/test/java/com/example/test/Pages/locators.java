package com.example.test.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class locators {


    public static WebElement acceptWarningButton(AppiumDriver driver){
        WebElement acceptWarningButton = driver.findElement(AppiumBy.id("android:id/button1"));
        return acceptWarningButton;
    }

    public static void openAssertMenu(AppiumDriver driver){
        WebElement menuButton = driver.findElement(AppiumBy.accessibilityId("Open drawer"));
        menuButton.click();
        WebElement menuItem1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Flows\").instance(1)"));
        WebElement menuItem2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Community\").instance(1)"));
        WebElement menuItem3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Reddit\").instance(1)"));
        WebElement menuItem4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Forum\").instance(1)"));
        WebElement menuItem5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Settings\")"));
        WebElement menuItem6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Help & feedback\")"));
        assertTrue(menuItem1.isDisplayed());
        assertTrue(menuItem2.isDisplayed());
        assertTrue(menuItem3.isDisplayed());
        assertTrue(menuItem4.isDisplayed());
        assertTrue(menuItem5.isDisplayed());
        assertTrue(menuItem6.isDisplayed());
    }

    public static void AddNewFlow(AppiumDriver driver){
        WebElement addButton = driver.findElement(AppiumBy.id("com.llamalab.automate:id/insert_flow"));
        addButton.click();
    }

    public static void closeInstructions(AppiumDriver driver, WebDriverWait wait){
        WebElement instructionModal = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        assertTrue(instructionModal.isDisplayed());
        String instructionsText = driver.findElement(AppiumBy.id("android:id/message")).getText();
        WebElement closeButton = driver.findElement(AppiumBy.id("android:id/closeButton"));
        assertTrue(instructionsText.contentEquals("Add blocks, then drag the dots to connect them."));
        closeButton.click();
    }
}
