package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SalesPage {
    private final SelenideElement applicationButton = $(".soft-dev_btn"),
            closeCookieButton = $(".privacy__cancel"),
            nameInput   = $("div.call-modal-2").$(by("name","name1")),
            phoneInput   = $("div.call-modal-2").$(by("name","phone1")),
            companyNameInput   = $("div.call-modal-2").$(by("name","organ")),
            messageInput   = $("div.call-modal-2").$(by("name","message1")),
            agreementCheckBox   = $("div.call-modal-2").$(by("for","check11")),
            submitButton = $("div.call-modal-2").$("button.modal-button"),
            subscribeDoneForm = $("div.form-messages").$(".subscribe__done");

    public SalesPage openPage() {
        open("/services/development/");
        $(".soft-dev__heading__title").shouldHave(text("Разработка"));
        if(closeCookieButton.is(visible)) closeCookieButton.click();

        return this;
    }

    public SalesPage openApplicationForm() {
        applicationButton.click();
        return this;
    }

    public SalesPage setName(String value) {
        nameInput.click();
        nameInput.setValue(value);

        return this;
    }

    public SalesPage setPhone(String value) {
        phoneInput.click();
        phoneInput.setValue(value);

        return this;
    }

    public SalesPage setCompanyName(String value) {
        companyNameInput.click();
        companyNameInput.setValue(value);

        return this;
    }

    public SalesPage setMessage(String value) {
        messageInput.click();
        messageInput.setValue(value);

        return this;
    }

    public SalesPage acceptTermsPersonalData() {
        agreementCheckBox.click();

        return this;
    }

    public SalesPage submit(){
        submitButton.click();

        return this;
    }

    public SalesPage checkResult() {
        subscribeDoneForm.shouldBe(visible);
        subscribeDoneForm.shouldHave(text("Ваше сообщение отправлено"));

        return this;
    }

    public SalesPage checkForError() {
        subscribeDoneForm.shouldNotBe(visible);

        return this;
    }

}