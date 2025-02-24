package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class RequestCallbackForm {
    private final SelenideElement reqCallButton = $("a.req-call"),
            closeCookieButton = $(".privacy__cancel"),
            nameInput   = $("div.call-modal").$(by("name","name1")),
            phoneInput   = $("div.call-modal").$(by("name","phone1")),
            companyNameInput   = $("div.call-modal").$(by("name","organ")),
            messageInput   = $("div.call-modal").$(by("name","message1")),
            agreementCheckBox = $("div.call-modal").$(by("for","check10")),
            submitButton = $("div.call-modal").$("button.modal-button"),
            subscribeDoneForm = $("div.form-messages").$(".subscribe__done");

    public RequestCallbackForm openPage() {
        open("");
        $("div.content").shouldBe(visible);
        if(closeCookieButton.is(visible)) closeCookieButton.click();

        return this;
    }

    public RequestCallbackForm openReqCallbackForm() {
        reqCallButton.click();
        return this;
    }

    public RequestCallbackForm setName(String value) {
        nameInput.click();
        nameInput.setValue(value);

        return this;
    }

    public RequestCallbackForm setPhone(String value) {
        phoneInput.click();
        phoneInput.setValue(value);

        return this;
    }

    public RequestCallbackForm setCompanyName(String value) {
        companyNameInput.click();
        companyNameInput.setValue(value);

        return this;
    }

    public RequestCallbackForm setMessage(String value) {
        messageInput.click();
        messageInput.setValue(value);

        return this;
    }

    public RequestCallbackForm acceptTermsPersonalData() {
        agreementCheckBox.click();

        return this;
    }

    public RequestCallbackForm submit(){
        submitButton.click();

        return this;
    }

    public RequestCallbackForm checkResult() {
        subscribeDoneForm.shouldBe(visible);
        subscribeDoneForm.shouldHave(text("Ваше сообщение отправлено"));

        return this;
    }

}