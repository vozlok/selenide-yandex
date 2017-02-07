package ru.yandex.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.*;

/**
 * Created by kai on 07.02.2017.
 */
public class BrowserFactory {

    public static void selectBrowser(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                ChromeDriverManager.getInstance().setup();
                break;
            default:
                throw new IllegalStateException("Browser " + browser + " not supported in tests");
        }
    }
}
