package ru.customertimes.at.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.customertimes.at.ui.BasePage;

import static junit.framework.Assert.assertEquals;
import static ru.customertimes.at.ui.WaitUtils.waitElementVisible;

@Slf4j
public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//div//button[.='Регистрация']")
    private WebElement registrationButton;

    @FindBy(name = "emailOrPhone")
    private WebElement emailField;

    @FindBy(name = "fullName")
    private WebElement nameField;

    @FindBy(name = "username")
    private WebElement userField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div//p[contains(text(), 'уже используется другим')]")
    private WebElement errorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что находимся на странице регистрации")
    public RegistrationPage onRegistrationPage() {
        log.info("Проверяем, что находимся на странице регистрации");
        assertEquals("https://www.instagram.com/accounts/emailsignup/", driver.getCurrentUrl());
        waitElementVisible(driver, 20, registrationButton);
        assertEquals("Регистрация", registrationButton.getText());
        return new RegistrationPage(driver);
    }

    @Step("Заполняем поле email: {0}")
    public RegistrationPage fillEmailValue(String email) {
        log.info("Заполняем поле email: {}", email);
        emailField.sendKeys(email);
        return new RegistrationPage(driver);
    }

    @Step("Заполняем поле name: {0}")
    public RegistrationPage fillNameField(String name) {
        log.info("Заполняем поле name: {}", name);
        nameField.sendKeys(name);
        return new RegistrationPage(driver);
    }

    @Step("Заполняем поле user: {0}")
    public RegistrationPage fillUserNameField(String user) {
        log.info("Заполняем поле user: {}", user);
        userField.sendKeys(user);
        return new RegistrationPage(driver);
    }

    @Step("Заполняем поле password: {0}")
    public RegistrationPage fillPasswordField(String pass) {
        log.info("Заполняем поле password: {}", pass);
        passwordField.sendKeys(pass);
        return new RegistrationPage(driver);
    }

    @Step("Кликаем кнопку регистрации")
    public RegistrationPage submitForm() {
        log.info("Кликаем кнопку регистрации");
        registrationButton.submit();
        return new RegistrationPage(driver);
    }

    @Step("Проверяем наличие сообщение об ошибке с укзанием сущестуещего email: {0}")
    public RegistrationPage checkErrorMessage(String email) {
        log.info("Проверяем наличие сообщение об ошибке с укзанием сущестуещего email: {}", email);
        waitElementVisible(driver, 5, errorMessage);
        assertEquals("Адрес " + email + " уже используется другим аккаунтом.", errorMessage.getText());
        return new RegistrationPage(driver);
    }
}
