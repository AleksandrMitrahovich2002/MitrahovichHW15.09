import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends BasePage {

    private final SelenideElement usernameField = findElementByXpath("//input[@id='login-form-username']");
    private final SelenideElement passwordField = findElementByXpath("//input[@id='login-form-password']");
    private final SelenideElement loginButton = findElementByXpath("//input[@id='login-form-submit']");

    public void navigateToLoginPage() {
        open("https://edujira.ifellow.ru/login.jsp");
    }

    public void enterUsername(String username) {
        usernameField.shouldBe(visible).setValue(username);
    }

    public void enterPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }

    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    public void login(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        waitForUrlToContain("/secure/Dashboard.jspa");
    }
}