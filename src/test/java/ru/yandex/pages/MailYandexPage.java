package ru.yandex.pages;

import ru.yandex.core.UserInfo;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by kai on 07.02.2017.
 */
public class MailYandexPage {

    @Step("Проверка отображения email авторизованного пользователя на странице mail.yandex")
    public MailYandexPage checkAuthUser(UserInfo user) {
        $(".mail-User-Name").shouldHave(text(user.email));
        return this;
    }

    @Step("Кликаем на меню Профиля")
    public MailYandexPage clickMailProfile() {
        $(".mail-User-Name").click();
        return this;
    }

    @Step("В меню профиля кликаем 'Паспорт'")
    public PassportPage clickProfilePassport() {
        $(byXpath("//a[@href='https://passport.yandex.ru/passport?mode=passport']")).click();
        return new PassportPage();
    }

    @Step("Логаут пользователя с mail.yandex")
    public MainPage logoutUserFromMail() {
        clickMailProfile();
        $(byXpath("//a[@class='b-mail-dropdown__item__content ' and contains(.,'Выход')]")).click();
        return new MainPage();
    }
}
