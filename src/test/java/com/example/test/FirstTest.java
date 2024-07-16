package com.example.test;

import io.appium.java_client.AppiumBy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import com.example.test.Pages.locators;
import com.example.test.Pages.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FirstTest extends BaseSetUp {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testLogin() {
        //accept the warning
        locators.acceptWarningButton(driver).click();

        //open menu
        locators.openAssertMenu(driver);

        //Close the menu by swiping to the left
        WebElement menuElement = driver.findElement(AppiumBy.id("com.llamalab.automate:id/design_navigation_view"));
        Utils.swipeLeftMethod(driver, menuElement);

        //Add new flow
        locators.AddNewFlow(driver);

        //Close new flow instructions
        locators.closeInstructions(driver, wait);

        //move flow up
        WebElement flowElement = driver.findElement(AppiumBy.id("com.llamalab.automate:id/center"));
        Utils.swipeUpMethod(driver, flowElement);

        //Assert element to have been moved up
        WebElement movedElementWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.llamalab.automate:id/snackbar_text")));
        Assert.assertTrue(movedElementWarning.isDisplayed());
        String movedElementWarningText = driver.findElement(AppiumBy.id("com.llamalab.automate:id/snackbar_text")).getText();
        String expectedMovedElementWarning = "Moved “Flow beginning” block";
        Assert.assertEquals(movedElementWarningText, expectedMovedElementWarning);

        //MOVE FLOW DOWN
        Utils.swipeDownMethod(driver, flowElement);
        //Assert element to have been moved up
        WebElement movedDownWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.llamalab.automate:id/snackbar_text")));
        Assert.assertTrue(movedDownWarning.isDisplayed());

    }
}
