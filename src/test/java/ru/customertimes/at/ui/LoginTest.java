package ru.customertimes.at.ui;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.customertimes.at.ui.pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@DisplayName("Login test")
public class LoginTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    void initClass() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Severity(BLOCKER)
    @DisplayName("Login with correct credentials")
    @Parameters({"email", "password", "username"})
    @Test
    void loginTest(@Optional("namethatdefinitelyfree@gmail.com") String email,@Optional("q1w2e3r4t5y6") String password, @Optional("namethatdefinitelyfree") String username) {
        mainPage.goToIntPage()
                .onMainPage()
                .fillLoginField(email)
                .fillPasswordField(password)
                .submitLoginForm()
                .checkSuccessfulLogin(username);
    }

}
