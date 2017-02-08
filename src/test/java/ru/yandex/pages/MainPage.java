package ru.yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.core.UserInfo;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by kai on 07.02.2017.
 */
public class MainPage {

    @Step("Открытие главной страницы Yandex")
    public MainPage openMainPage(){
        open(baseUrl);
        $(byXpath("//a[@href='//home.yandex.ru/?from=prov_main']")).shouldBe(visible);
        return this;
    }

    @Step("Ввод Логина пользователя в форму авторизации")
    public MainPage setLogin(String login) {
        $(By.name("login")).setValue(login);
        return this;
    }

    @Step("Ввод пароля в форму авторизации")
    public MainPage setPassword(String password) {
        $(By.name("passwd")).setValue(password);
        return this;
    }

    @Step("Клик по кнопке Войти. Успешная авторизация")
    public MailYandexPage clickLogin() {
        $(".domik2__submit button").click();
        return new MailYandexPage();
    }

    @Step("Клик по кнопке Войти. Валидация значений Логин/Пароль")
    public MainPage clickLoginValidation() {
        $(".domik2__submit button").click();
        return this;
    }

    @Step("Авторизация пользователя")
    public MailYandexPage authUser(UserInfo user){
        return setLogin(user.email).setPassword(user.password).clickLogin();
    }

    @Step("Проверка подсказки обязательности поля Логин")
    public MainPage validateLoginReq() {
        String attr = $(byXpath("//div[@class='popup__content auth__error']/..")).getAttribute("style");
        Assert.assertThat(attr, containsString("top: 71px;"));
        return this;
    }

    @Step("Проверка подсказки обязательности поля Пароль")
    public MainPage validatePasswordReq() {
        String attr = $(byXpath("//div[@class='popup__content auth__error']/..")).getAttribute("style");
        Assert.assertThat(attr, containsString("top: 111px;"));
        return this;
    }

    @Step("Клик по кнопке Войти. Неверный Логин/Пароль")
    public PassportAuthPage clickLoginIncorrectPass() {
        $(".domik2__submit button").click();
        return new PassportAuthPage();
    }

    @Step("Кликаем на кнопку 'Найти' в поисковой строке")
    public SearchPage clickSearch() {
        $(".search2__button button").click();
        return new SearchPage();
    }

    @Step("Заполнение строки поиска")
    public MainPage setSearchValue(String search) {
        $("#text").setValue(search);
        return this;
    }

    @Step("Поиск значения (ввод значения+Enter)")
    public SearchPage yandexSearch(String search) {
        $("#text").setValue(search).pressEnter();
        return new SearchPage();
    }

    @Step("Переход по ссылке 'примера поиска'")
    public String yandexExampleSearch() {
        String search =  $(".input__samples span span").getText();
        $(".input__samples span span span").click();
        return search;
    }

    @Step("Кликаем на ссылку восстановления аккаунта")
    public RestorePage clickRestoreUser() {
        $(byXpath("//a[@href='https://passport.yandex.ru/passport?mode=restore']")).click();
        return new RestorePage();
    }
}
