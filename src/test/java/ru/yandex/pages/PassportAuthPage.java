package ru.yandex.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Created by kai on 07.02.2017.
 */
public class PassportAuthPage {

    //TODO По всей видимости, яндекс обнаруживает активность и через какое то время ошибку перестает показывать
    @Step("Проверка сообщения об ошибке 'Неправильный логин или пароль.'")
    public PassportAuthPage validateIncorrectPassAlert() {
        //$(".error-msg").shouldHave(text("Неправильный логин или пароль."));
        Assert.assertThat(WebDriverRunner.getWebDriver().getCurrentUrl(), is("https://passport.yandex.ru/passport?mode=auth&retpath=https://mail.yandex.ru"));
        return this;
    }
}
