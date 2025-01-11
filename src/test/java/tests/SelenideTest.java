package tests;

import org.junit.jupiter.api.Test;
import steps.SelenideStep;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class SelenideTest extends TestBase {

    @Test
    public void lambdaCheckRedirectOnGitTest () {
        step("Открываем главную страницу github.com", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $(byText("Search or jump to...")).click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });
        step("Открываем репозиторий " + REPOSITORY,() -> {
            $(byText(REPOSITORY+"/")).click();
        });
        step("Переходим в раздел " + TITLE,() ->{
            $(byText(TITLE)).click();
        });
        step("Проверяем заголовок",() ->{
            $("#wiki-wrapper").$("div",0).shouldHave(text(TITLE));
        });
    }

    @Test
    public void annotationCheckRedirectOnGitTest () {
        SelenideStep steps = new SelenideStep();
        steps.openMainPage()
        .searchRepository()
        .openRepository()
        .goToSectionQuickStart()
        .checkTitleName();
    }

    @Test
    public void originCheckRedirectOnGitTest () {
            open("https://github.com");
            $(byText("Search or jump to...")).click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
            $(byText(REPOSITORY+"/")).click();
            $(byText(TITLE)).click();
            $("#wiki-wrapper").$("div",0).shouldHave(text(TITLE));
    }
}
