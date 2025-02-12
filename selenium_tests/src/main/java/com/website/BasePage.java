package com.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement locate(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        locate(locator).click();
    }

    public void delay(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000)); // Convert seconds to milliseconds (long type)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
