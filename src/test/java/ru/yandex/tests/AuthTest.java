package ru.yandex.tests;

import org.junit.Test;
import ru.yandex.core.UserInfo;
import ru.yandex.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;

import static ru.yandex.core.UserAssistant.getTestUser;

/**
 * Created by kai on 07.02.2017.
 */
@Title("Тесты по авторизации на главной странице Yandex")
public class AuthTest extends TestBase {

    @Title("Успешная авторизация пользователя (логин = email)")
    @Test
    public void AuthUserByEmail(){
        UserInfo user = getTestUser();
        new MainPage().
                openMainPage().
                setLogin(user.email).
                setPassword(user.password).
                clickLogin().
                checkAuthUser(user).
                logoutUserFromMail();
    }

    @Title("Успешная авторизация пользователя (логин = login)")
    @Test
    public void AuthUserByLogin(){
        UserInfo user = getTestUser();
        new MainPage().
                openMainPage().
                setLogin(user.login).
                setPassword(user.password).
                clickLogin().
                checkAuthUser(user).
                logoutUserFromMail();
    }

    @Title("Валидация пустых значений полей Логин и Пароль")
    @Test
    public void ValidateAuthFields(){
        UserInfo user = getTestUser();
        new MainPage().
                openMainPage().
                clickLoginValidation().
                validateLoginReq().
                setLogin(user.login).
                clickLoginValidation().
                validatePasswordReq();
    }

    @Title("Ошибка авторизации. Неверный логин/пароль")
    @Test
    public void UnsuccessfulAuthUser(){
        UserInfo user = getTestUser();
        new MainPage().
                openMainPage().
                setLogin(user.login).
                setPassword(user.password+"1").
                clickLoginIncorrectPass().
                validateIncorrectPassAlert();
    }
}
