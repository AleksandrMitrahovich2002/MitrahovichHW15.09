import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProjectPage extends BasePage {

    private final SelenideElement issuesCounter = findElementByXpath("//span[contains(@class, 'results-count-total')]");
    private final SelenideElement issueTestSelenium = findElementByXpath("//a[text()='TestSeleniumATHomework']");

    // Класс-обертка для работы со счетчиком задач
    public static class IssuesCounter {
        private final int current;
        private final int total;

        public IssuesCounter(String counterText) {
            String[] parts = counterText.split(" из ");
            this.current = Integer.parseInt(parts[0]);
            this.total = Integer.parseInt(parts[1]);
        }

        public int getCurrent() { return current; }
        public int getTotal() { return total; }

        @Override
        public String toString() {
            return current + " из " + total;
        }

        public IssuesCounter getExpectedCounterAfterCreation() {
            return new IssuesCounter((current + 1) + " из " + (total + 1));
        }
    }

    public IssuesCounter getIssuesCounter() {
        String counterText = issuesCounter.shouldBe(visible).getText();
        return new IssuesCounter(counterText);
    }

    public void openIssueTestSelenium() {
        issueTestSelenium.shouldBe(visible).click();
        waitForUrlToContain("/browse/TEST-");
    }

    public void verifyIssuesCounter(IssuesCounter expectedCounter) {
        issuesCounter.shouldHave(visible, text(expectedCounter.toString()));
    }
}