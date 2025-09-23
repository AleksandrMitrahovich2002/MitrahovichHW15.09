import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public abstract class BasePage {

    protected SelenideElement findElementByXpath(String xpath) {
        return $(org.openqa.selenium.By.xpath(xpath));
    }

    protected void pressEnter() {
        $("body").sendKeys(Keys.ENTER);
    }

    protected void waitForUrlToContain(String partialUrl) {
        webdriver().shouldHave(urlContaining(partialUrl));
    }
}