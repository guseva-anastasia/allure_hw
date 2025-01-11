package steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestBase.*;


public class SelenideStep {

    public SelenideElement
    searchString = $("#query-builder-test"),
    wikiWrapper = $("#wiki-wrapper");

    @Step("Открываем главную страницу")
    public SelenideStep openMainPage(){
        open("");
        return this;
    }

    @Step("Поиск репозитория " + REPOSITORY)
    public SelenideStep searchRepository(){
        $(byText("Search or jump to...")).click();
        searchString.setValue(REPOSITORY).submit();
        return this;
    }

    @Step("Открываем репозиторий " + REPOSITORY)
    public SelenideStep openRepository(){
        $(byText(REPOSITORY+"/")).click();
        return this;
    }

    @Step("Переходим в раздел " + TITLE)
    public SelenideStep goToSectionQuickStart(){
        $(byText(TITLE)).click();
        return this;
    }

    @Step ("Проверяем заголовок")
    public SelenideStep checkTitleName(){
        wikiWrapper.$("div",0).shouldHave(text(TITLE));
        return this;
    }
}
