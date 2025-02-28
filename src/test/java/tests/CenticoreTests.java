package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ContactsPage;
import pages.RequestCallbackForm;
import pages.SalesPage;
import pages.VacanciesPage;
import testData.TestDataGenerationFaker;


import static io.qameta.allure.Allure.step;

@Tag("fullTest")
public class CenticoreTests extends TestBase {

    ContactsPage contactsPage = new ContactsPage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    TestDataGenerationFaker tData = new TestDataGenerationFaker();
    SalesPage salesPage = new SalesPage();
    RequestCallbackForm requestCallbackForm = new RequestCallbackForm();
    @Test
    void contactsPageShouldContainAllLocationsTest() {

        step("Открыть страницу Контакты", () -> {
            contactsPage.openPage();
        });

        step("Проверить наличие всех локаций", () -> {
            contactsPage.checkResult();
        });
    }

    @Test
    void vacanciesListShouldContainRelevantItemsOrBeEmptyTest() {

        step("Открыть страницу Вакансии", () -> {
            vacanciesPage.openPage();
        });

        step("Выбрать категорию Тестирование", () -> {
            vacanciesPage.selectSpecQA();
        });

        step("Проверить наличие релевантных вакансий", () -> {
            vacanciesPage.checkResult();
        });
    }

    @Test
    void fullFilledApplicationForPartnershipShouldDisplaySuccessMessageTest(){
        step("Открыть страницу Разработка ПО", () -> {
            salesPage.openPage();
        });

        step("Открыть форму Забронировать консультацию", () -> {
            salesPage.openApplicationForm();
        });

        step("Заполнить форму", () -> {
            salesPage.setName(tData.firstName)
                    .setPhone(tData.phoneNumber)
                    .setCompanyName(tData.companyName)
                    .setMessage(tData.message)
                    .acceptTermsPersonalData();
        });

        step("Отправить заявку", () -> {
            salesPage.submit();
        });

        step("Проверить результат", () -> {
            salesPage.checkResult();
        });
    }

    @Test
    void partFilledApplicationForPartnershipShouldDisplayErrorMessageTest(){
        step("Открыть страницу Разработка ПО", () -> {
            salesPage.openPage();
        });

        step("Открыть форму Забронировать консультацию", () -> {
            salesPage.openApplicationForm();
        });

        step("Заполнить форму", () -> {
            salesPage.setName(tData.firstName)
                    .setCompanyName(tData.companyName)
                    .setMessage(tData.message)
                    .acceptTermsPersonalData();
        });

        step("Отправить заявку", () -> {
            salesPage.submit();
        });

        step("Проверить результат", () -> {
            salesPage.checkForError();
        });
    }

    @Test
    void fullFilledRequestCallbackFormShouldDisplaySuccessMessageTest(){
        step("Открыть страницу Разработка ПО", () -> {
            requestCallbackForm.openPage();
        });

        step("Открыть форму Забронировать консультацию", () -> {
            requestCallbackForm.openReqCallbackForm();
        });

        step("Заполнить форму", () -> {
            requestCallbackForm.setName(tData.firstName)
                    .setPhone(tData.phoneNumber)
                    .setCompanyName(tData.companyName)
                    .setMessage(tData.message)
                    .acceptTermsPersonalData();
        });

        step("Отправить заявку", () -> {
            requestCallbackForm.submit();
        });

        step("Проверить результат", () -> {
            requestCallbackForm.checkResult();
        });
    }
}