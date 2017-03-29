package ru.yandex.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.core.Is.is;

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

    @Step("Проверка слова на всех страницах")
    public void checkOrtnecAllLink(String search) {
        List<String> items = new ArrayList<String>();
        for (SelenideElement item : $$("li.serp-item.t-construct-adapter__legacy div h2 > a")){
            items.add(item.getAttribute("href"));
        }
        for (String url : items) {
            open(url);
            /* По условию кейса, нужно искать ortnec с маленькой => Если в поиске находится сайт где нет ortnec с маленькой
                то тест падает. В моем случае тест падает на сайте https://angel.co/ortnec
                на этой странице нет ortnec, есть только Ortnec
            */
            $(byXpath("//html/body[contains(.,'"+search.toLowerCase()+"')]")).shouldBe(visible);
        }
    }
}
