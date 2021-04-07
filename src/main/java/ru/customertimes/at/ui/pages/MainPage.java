package ru.customertimes.at.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.customertimes.at.ui.BasePage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static ru.customertimes.at.ui.WaitUtils.waitElementVisible;


@Slf4j
public class MainPage extends BasePage {


    @FindBy(xpath = "//h1[text()='Instagram']")
    private WebElement instagramTitle;

    @FindBy(xpath = "//span[text()='Зарегистрироваться']")
    private WebElement registrationLink;

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//nav//div//span/img[contains(@alt, 'Фото')]")
    private WebElement profileButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @Step("Проверяем, что находимся на главной странице")
    public MainPage onMainPage() {
        log.info("Проверяем, что находимся на главной странице");
        assertEquals(props.instagramUrl(), driver.getCurrentUrl());
        waitElementVisible(driver, 20, instagramTitle);
        assertTrue(instagramTitle.isDisplayed());
        return new MainPage(driver);
    }

    @Step("Переходим к странице регистрации")
    public RegistrationPage goToRegistrationPage() {
        log.info("Переходим к странице регистрации");
        waitElementVisible(driver, 10, registrationLink);
        registrationLink.click();
        return new RegistrationPage(driver);
    }

    @Step("Заполняем поле login: {0}")
    public MainPage fillLoginField(String login) {
        log.info("Заполняем поле login: {}", login);
        loginField.sendKeys(login);
        return new MainPage(driver);
    }

    @Step("Заполняем поле password: {0}")
    public MainPage fillPasswordField(String password) {
        log.info("Заполняем поле password: {}", password);
        passwordField.sendKeys(password);
        return new MainPage(driver);
    }

    @Step("Кликаем кнопку Войти")
    public MainPage submitLoginForm() {
        log.info("Кликаем кнопку Войти");
        assertEquals("Войти", submitButton.findElement(By.xpath("./div")).getText());
        submitButton.submit();
        return new MainPage(driver);
    }


    @Step("Проверяем, что авторизация успешна. У картинки профиля присутсвует {0}")
    public MainPage checkSuccessfulLogin(String login) {
        log.info("Проверяем, что авторизация успешна. У картинки профиля присутсвует {}", login);
        profileButton.getAttribute("alt");
        waitElementVisible(driver, 5, profileButton);
        assertTrue("Кнопка отсутсвует", profileButton.isDisplayed());
        assertTrue(login + " не соответствует", profileButton.getAttribute("alt").contains(login));
        return new MainPage(driver);
    }
}
