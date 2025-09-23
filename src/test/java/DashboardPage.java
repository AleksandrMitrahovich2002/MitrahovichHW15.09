import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
//*[@id="admin_main_proj_link_lnk"]
public class DashboardPage extends BasePage {
    private final SelenideElement projectsMenu = findElementByXpath("//*[@id='browse_link']");
    private final SelenideElement projectTestLink = findElementByXpath("//*[@id='admin_main_proj_link_lnk']");

    public void goToProjectTest() {
        projectsMenu.shouldBe(visible).click();
        projectTestLink.shouldBe(visible).click();
        waitForUrlToContain("/projects/TEST");
    }
}