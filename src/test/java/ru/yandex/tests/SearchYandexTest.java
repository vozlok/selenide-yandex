package ru.yandex.tests;

import org.junit.Test;
import ru.yandex.pages.MainPage;
import ru.yandex.pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Андрей on 07.02.2017.
 */
@Title("Тесты 'поисковая строка' на главной странице Yandex")
public class SearchYandexTest extends TestBase {

    @Title("Поиск по пустому значению")
    @Test
    public void SearchEmpty(){
        new MainPage().
                openMainPage().
                yandexSearch("").
                checkEmptySearch();
    }

    @Title("Поиск yandex")
    @Test
    public void YandexSearch(){
        String search = "petrosoft";
        new MainPage().
                openMainPage().
                yandexSearch(search).
                checkResultSize10().
                checkFirstResult(search);
    }

    @Title("Поиск yandex. Переход по ссылке из примера поиска.")
    @Test
    public void YandexExampleSearch(){
        String exampleText = new MainPage().
                                    openMainPage().
                                    yandexExampleSearch();
        new SearchPage().
                checkSearchValue(exampleText);
    }
}
