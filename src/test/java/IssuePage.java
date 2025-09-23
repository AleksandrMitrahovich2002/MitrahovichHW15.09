import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IssuePage extends BasePage {

    private final SelenideElement statusField = findElementByXpath("//span[@id='status-val']");
    private final SelenideElement fixVersionsField = findElementByXpath("//span[@id='fixfor-val']");
    private final SelenideElement createIssueButton = findElementByXpath("//a[@id='create_link']");

    public void verifyStatus(String expectedStatus) {
        statusField.shouldHave(text(expectedStatus));
    }

    public void verifyFixVersion(String expectedVersion) {
        fixVersionsField.shouldHave(text(expectedVersion));
    }

    public void clickCreateIssue() {
        createIssueButton.shouldBe(visible).click();
        waitForUrlToContain("/CreateIssue!default.jspa");
    }
}