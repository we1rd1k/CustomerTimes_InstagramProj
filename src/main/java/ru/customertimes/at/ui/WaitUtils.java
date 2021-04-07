package ru.customertimes.at.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {


    public static void waitElementVisible(WebDriver driver, Integer timeOut, WebElement element) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementClickable(WebDriver driver, Integer timeOut, WebElement element) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
    }

}
