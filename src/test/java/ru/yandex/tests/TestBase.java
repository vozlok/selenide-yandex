package ru.yandex.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.ClassRule;
import org.junit.Rule;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.utils.CustomExternalResource;
import ru.yandex.utils.CustomWatcher;

public class TestBase {

    @Rule
    public CustomWatcher customWatcher = new CustomWatcher();

    @ClassRule
    public static CustomExternalResource beforeResource = new CustomExternalResource();

    @Step("Чистим куки у браузера")
    public static void clearCookies() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
