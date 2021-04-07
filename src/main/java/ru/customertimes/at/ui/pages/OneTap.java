package ru.customertimes.at.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.customertimes.at.ui.BasePage;

public class OneTap extends BasePage {


    @FindBy(xpath = "//section//div[text()='Сохранить данные для входа?']")
    private WebElement oneTapSection;

    @FindBy(xpath = "//button[text()='Не сейчас']")
    private WebElement buttonNotNow;

    public OneTap(WebDriver driver) {
        super(driver);
    }


}
