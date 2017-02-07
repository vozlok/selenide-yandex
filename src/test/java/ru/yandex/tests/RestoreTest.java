package ru.yandex.tests;

import org.junit.Test;
import ru.yandex.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Андрей on 08.02.2017.
 */
@Title("Восстановление доступа")
public class RestoreTest extends TestBase {

    @Title("Переход на страницу восстановления аккаунта")
    @Test
    public void gotoRestorePage(){
        new MainPage().
                openMainPage().
                clickRestoreUser().
                checkRestorePage();
    }

}
