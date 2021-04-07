package ru.customertimes.at.ui;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.customertimes.at.ui.pages.MainPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class RegistrationTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    void initClass() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Severity(CRITICAL)
    @DisplayName("Registration with exist credentials")
    @Test(dataProvider = "Failed credentials")
    void failedRegistrationTest(String email, String name, String user, String password) {
        mainPage.goToIntPage().onMainPage()
                .goToRegistrationPage()
                .onRegistrationPage()
                .fillEmailValue(email)
                .fillNameField(name)
                .fillUserNameField(user)
                .fillPasswordField(password)
                .submitForm()
                .checkErrorMessage(email);
    }

    @DataProvider(name = "Failed credentials")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"namethatdefinitelyfree@gmail.com", "f34523v4cwqec", "awearbvrg", "dsafasdf"}};
    }
}
