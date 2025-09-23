import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DashboardPage extends BasePage {

    private final SelenideElement projectsMenu = findElementByXpath("//a[@id='browse_link']");
    private final SelenideElement projectTestLink = findElementByXpath("//a[contains(text(),'TEST')]");

    public void goToProjectTest() {
        projectsMenu.shouldBe(visible).click();
        projectTestLink.shouldBe(visible).click();
        waitForUrlToContain("/browse/TEST");
    }
}