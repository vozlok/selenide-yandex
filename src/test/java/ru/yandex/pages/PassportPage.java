package ru.yandex.pages;

import ru.yandex.core.UserInfo;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by kai on 07.02.2017.
 */
public class PassportPage {

    @Step("Проверка персональной информации на странице passport.yandex")
    public PassportPage checkPassportInfo(UserInfo user) {
        return checkLogin(user.login);
    }

    @Step("Проверка Логина пользователя")
    public PassportPage checkLogin(String login){
        $(".personal-info-login").shouldHave(text(login));
        return this;
    }

    @Step("Логаут пользователя со страницы passport")
    public PassportAuthPage logoutUserFromPassport(UserInfo user) {
        $(byXpath("//a[@class='header-user']/span[contains(.,'"+user.login+"')]")).click();
        $(byXpath("//a[contains(.,'Выход')]")).click();
        return new PassportAuthPage();
    }
}
