import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.*;

public class JiraTest extends TestBase {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final IssuePage issuePage = new IssuePage();
    private final CreateIssuePage createIssuePage = new CreateIssuePage();

    @Test
    public void test1_Authorization() {
        // 1. Авторизоваться в edujira.ifellow.ru
        loginPage.login("AT13", "Qwerty123");

        // Проверка авторизации
        assertTrue("Должны быть на dashboard после авторизации",
                webdriver().driver().url().contains("/secure/Dashboard.jspa"));
    }

    @Test
    public void test2_NavigateToProject() {
        test1_Authorization();

        // 2. Перейти в проект "Test"
        dashboardPage.goToProjectTest();

        // Проверка перехода в проект
        assertTrue("Должны быть на странице проекта TEST",
                webdriver().driver().url().contains("/projects/TEST"));
    }

    @Test
    public void test3_VerifyIssuesCounter() {
        test2_NavigateToProject();

        // 3. Проверить общее количество заведенных задач в проекте
        ProjectPage.IssuesCounter initialCounter = projectPage.getIssuesCounter();
        System.out.println("Initial counter: " + initialCounter);
        int currentIssuesNum = initialCounter.getTotal();

        // Создаем задачу
        projectPage.createTask();

        assertTrue("Счетчик должен быть положительным числом и больше начального на 1",
                projectPage.getIssuesCounter().getTotal() > currentIssuesNum);
    }

    @Test
    public void test4_VerifyIssueDetails() {
        test3_VerifyIssuesCounter();

        // 4. Перейти в задачу TestSeleniumATHomework и проверить детали
        projectPage.openIssueTestSelenium();

        issuePage.verifyStatus("Сделать");
        issuePage.verifyFixVersion("Version 2.0");
    }

    @Test
    public void test5_CreateAndCloseBug() {
        test4_VerifyIssueDetails();

        issuePage.clickCreateIssue();
        createIssuePage.createNewBug(
                "TEST",
                "Новый баг созданный автотестом",
                "Описание бага созданного автотестом",
                "Окружение для тестирования"
        );
    }
}