package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {
    private final SelenideElement   specSelect = $(".nice-select"),
                                    vacansiesList  = $(".vacancies__list");

    private final ElementsCollection    specOption      = $$(".option"),
                                        vacanciesItem   = $$(".vacancies__item");

    public VacanciesPage openPage() {
        open("/vacancies/");
        $(".heading__title").shouldHave(text("Вакансии"));

        return this;
    }

    public VacanciesPage selectSpecQA() {
        specSelect.click();
        specOption.last().click();
        return this;
    }

    public VacanciesPage checkResult() {
        if(!vacanciesItem.isEmpty()){
            vacansiesList.shouldHave(text("QA"));
        }

        return this;
    }


}