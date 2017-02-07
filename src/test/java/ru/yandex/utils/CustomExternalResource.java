package ru.yandex.utils;

import com.codeborne.selenide.Configuration;
import org.junit.rules.ExternalResource;

import static com.codeborne.selenide.Selenide.sleep;
import static ru.yandex.tests.TestBase.clearCookies;
import static ru.yandex.utils.BrowserFactory.selectBrowser;
import static ru.yandex.utils.PropertiesReader.getProperty;
import static ru.yandex.utils.PropertiesReader.readPropertiesFile;

public class CustomExternalResource extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        Configuration.timeout = 10000;
        readPropertiesFile();
        selectBrowser(getProperty("browser"));
        Configuration.baseUrl = getProperty("baseUrl");
        clearCookies();
        sleep(1000);
    }
}
