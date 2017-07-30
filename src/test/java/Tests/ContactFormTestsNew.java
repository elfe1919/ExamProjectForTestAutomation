package Tests;


import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Kleine-Hexe on 30.07.2017.
 */
public class ContactFormTestsNew extends ParentTest{

    @Test
    public void successfulSendingContactForm(){
        contactFormPage.openContactFormPage();
        contactFormPage.enterClientNameInContactForm("TestName1");
        contactFormPage.enterClientEmailInContactForm("testemail@test.ua");
        contactFormPage.selectClientCityFromDDByName("city 1");
        contactFormPage.enterSubjectIntoContactForm("TestSubject");
        contactFormPage.enterMessageIntoContactForm("TestMessage");
        contactFormPage.checkingCheckboxVar2();
        contactFormPage.clickOnSubmitButton();
        checkAC("No message appeared",
                contactFormPage.isElementWithTextPresent("Спасибо за Ваше сообщение. Оно успешно отправлено."),true);
    }

    @Test
    public void sendingEmptyContactFormErrorMessage(){
        contactFormPage.openContactFormPage();
        contactFormPage.clickOnSubmitButton();
        checkAC("No message appeared",
                contactFormPage.isElementWithTextPresent("Одно или несколько полей содержат ошибочные данные. Пожалуйста, проверьте их и попробуйте ещё раз"),
                true);
        Assert.assertTrue("ErrorMessage for Field Client Name is not present",
                contactFormPage.checkErrorMessageForClientNameField("Поле обязательно для заполнения."));
        Assert.assertTrue("ErrorMessage for Field Client Email is not present",
                contactFormPage.checkErrorMessageForClientEmailField("Поле обязательно для заполнения."));
        Assert.assertTrue("ErrorMessage for DropDown Client City is not present",
                contactFormPage.checkErrorMessageForClientCityDD("Поле обязательно для заполнения."));


    }

}
