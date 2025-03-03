package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {
    private final SelenideElement   specSelect = $(".nice-select"),
                                    vacansiesList  = $(".vacancies__list");

    private final ElementsCollection    specOption      = $$(".option"),
                                        vacanciesItem   = $$(".vacancies__item");

    @Step("Открыть страницу Вакансии")
    public VacanciesPage openPage() {
        open("/vacancies/");
        $(".heading__title").shouldHave(text("Вакансии"));

        return this;
    }

    @Step("Выбрать категорию Тестирование")
    public VacanciesPage selectSpecQA() {
        specSelect.click();
        specOption.last().click();
        return this;
    }

    @Step("Проверить наличие релевантных вакансий")
    public VacanciesPage checkResult() {
        if(!vacanciesItem.isEmpty()){
            vacansiesList.shouldHave(text("QA"));
        }

        return this;
    }


}