package ru.yandex.pages;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Андрей on 07.02.2017.
 */
public class SearchPage {

    @Step("Проверка пустого запроса")
    public SearchPage checkEmptySearch() {
        $(byXpath("//div[@class='misspell__message']")).shouldHave(text("Задан пустой поисковый запрос"));
        return this;
    }

    //Бывают и другие коллекции
    @Step("Проверка коллекции результатов 10 шт.")
    public SearchPage checkResultSize10() {
        $$(".content__left li").shouldHaveSize(10);
        return this;
    }

    @Step("Проверка первой найденной ссылки")
    public SearchPage checkFirstResult(String search) {
        $(".content__left li").shouldHave(text(search));
        return this;
    }

    @Step("Проверка содержимого строки поиска")
    public SearchPage checkSearchValue(String searchValue) {
        $(By.name("text")).shouldHave(value(searchValue));
        return this;
    }
}
