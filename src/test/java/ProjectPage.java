import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class ProjectPage extends BasePage {

    private final SelenideElement issuesCounter = findElementByXpath("//*[@id='main']/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]/span");
    private final SelenideElement issueTestSelenium = findElementByXpath("//a[text()='TestSeleniumATHomework']");
    private final SelenideElement createTaskSelenium = findElementByXpath("//*[@id=\"create_link\"]");
    private final SelenideElement confirmCreationTaskSelenium = findElementByXpath("//*[@id=\"create-issue-submit\"]");
    private final SelenideElement topicInput = findElementByXpath("//*[@id=\"summary\"]");

    public void createTask() {
        createTaskSelenium.shouldBe(visible).click();
        topicInput.shouldBe(visible).setValue("Some topic name");
        confirmCreationTaskSelenium.shouldBe(visible).click();
        refresh();
    }

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
        open("https://edujira.ifellow.ru/browse/TEST-121544");
        waitForUrlToContain("/browse/TEST-121544");
    }

    public void verifyIssuesCounter(IssuesCounter expectedCounter) {
        issuesCounter.shouldHave(visible, text(expectedCounter.toString()));
    }
}