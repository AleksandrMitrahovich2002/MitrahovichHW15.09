import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class CreateIssuePage extends BasePage {

    private final SelenideElement projectField = findElementByXpath("//input[@id='project-field']");
    private final SelenideElement issueTypeField = findElementByXpath("//input[@id='issuetype-field']");
    private final SelenideElement summaryField = findElementByXpath("//input[@id='summary']");
    private final SelenideElement descriptionTab = findElementByXpath("//a[contains(text(),'Визуальный')]");
    private final SelenideElement environmentTab = findElementByXpath("//div[@id='environment-chooser']//a[contains(text(),'Визуальный')]");
    private final SelenideElement descriptionField = findElementByXpath("//div[@id='description-wiki-edit']//div[@role='textbox']");
    private final SelenideElement environmentField = findElementByXpath("//div[@id='environment-wiki-edit']//div[@role='textbox']");
    private final SelenideElement submitButton = findElementByXpath("//input[@id='create-issue-submit']");

    public void createNewBug(String project, String summary, String description, String environment) {
        // Заполнение основных полей
        projectField.shouldBe(visible).setValue(project).pressEnter();
        issueTypeField.shouldBe(visible).setValue("Ошибка").pressEnter();
        summaryField.shouldBe(visible).setValue(summary);

        // Проверка и переключение на визуальный редактор для описания
        if (!descriptionTab.getAttribute("class").contains("active")) {
            descriptionTab.click();
        }

        // Проверка и переключение на визуальный редактор для окружения
        if (!environmentTab.getAttribute("class").contains("active")) {
            environmentTab.click();
        }

        // Заполнение полей
        descriptionField.shouldBe(visible).setValue(description);
        environmentField.shouldBe(visible).setValue(environment);

        // Создание задачи
        submitButton.click();
        waitForUrlToContain("/browse/TEST-");
    }
}