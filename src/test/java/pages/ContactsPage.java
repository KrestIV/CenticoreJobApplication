package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {
    private final SelenideElement locationTabList = $(".locations__tab-list");

    @Step("Открыть страницу КОНТАКТЫ")
    public ContactsPage openPage() {
        open("/contacts/");
        $(".heading__title").shouldHave(text("Контакты"));

        return this;
    }

    @Step("Проверить наличие локаций")
    public ContactsPage checkResult() {
        locationTabList.shouldHave(text("Москва"));
        locationTabList.shouldHave(text("Санкт-Петербург"));
        locationTabList.shouldHave(text("Гонконг"));

        return this;
    }
}