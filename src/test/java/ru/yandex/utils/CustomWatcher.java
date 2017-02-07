package ru.yandex.utils;

import com.codeborne.selenide.Screenshots;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static ru.yandex.utils.AllureReportUtil.attachScreenshot;


public class CustomWatcher extends TestWatcher {

    @Override
    protected void starting(Description test) {
        Screenshots.startContext(test.getClassName(), test.getMethodName());
    }

    @Override
    protected void succeeded(Description description) {
        attachScreenshot();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        attachScreenshot();
    }
}
