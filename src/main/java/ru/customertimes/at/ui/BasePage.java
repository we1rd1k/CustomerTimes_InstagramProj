package ru.customertimes.at.ui;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.customertimes.at.ui.pages.MainPage;

@Slf4j
public class BasePage {

    protected static Props props = ConfigFactory.create(Props.class);
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Переходим на главную страницу")
    public MainPage goToIntPage() {
        log.info("Переходим на главную страницу");
        driver.get(props.instagramUrl());
        return new MainPage(driver);
    }
}
