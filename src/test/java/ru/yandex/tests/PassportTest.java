package ru.yandex.tests;

import org.junit.Test;
import ru.yandex.core.UserInfo;
import ru.yandex.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;

import static ru.yandex.core.UserAssistant.getTestUser;

/**
 * Created by kai on 07.02.2017.
 */
@Title("Тесты на функциональность passport.yandex")
public class PassportTest extends TestBase {

    @Title("Проверка Логина на странице passport. Переход на passport через почту")
    @Test
    public void CheckPassportInfo(){
        UserInfo user = getTestUser();
        new MainPage().
                openMainPage().
                authUser(user).
                clickMailProfile().
                clickProfilePassport().
                checkPassportInfo(user).
                logoutUserFromPassport(user);
    }

}
