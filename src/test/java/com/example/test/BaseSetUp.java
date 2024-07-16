package com.example.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseSetUp {
    protected AppiumDriver driver;
    protected WebDriverWait wait;


    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 7 API 35");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/Users/mariamendez//Downloads/com.llamalab.automate_1.31.1-191_minAPI14(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk");
        capabilities.setCapability("autoGrantPermissions", true);
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // 20 seconds timeout
    }

    public void tearDown(){
        driver.quit();
    }
}
