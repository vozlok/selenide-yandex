package ru.yandex.pages;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Андрей on 08.02.2017.
 */
public class RestorePage {

    @Step("Проверка наличия элементов на странице restore")
    public RestorePage checkRestorePage() {
        $("h1").shouldHave(text("Восстановление доступа"));
        $("#login-simple").shouldBe(visible);
        return this;
    }
}
