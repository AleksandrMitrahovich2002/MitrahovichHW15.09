import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public abstract class TestBase {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

        // Открытие браузера на весь экран (автоматическое определение размера)
        open();
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
