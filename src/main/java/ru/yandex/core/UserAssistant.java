package ru.yandex.core;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by kai on 07.02.2017.
 */
public class UserAssistant {
    @Step("Получить данные тестового пользователя")
    public static UserInfo getTestUser() {
        UserInfo user = new UserInfo("petroselenide", "123qweRT", "petroselenide@yandex.ru");
        return user;
    }
}
