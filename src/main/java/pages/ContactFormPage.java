package pages;

import javafx.scene.web.WebEngineBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactFormPage extends ParentPage {

    @FindBy(name = "your-name")
    private WebElement clientNameField;

    @FindBy(name = "your-email")
    private WebElement clientEmailField;

    @FindBy(id = "City")
    private WebElement clientCityDD;

    @FindBy (name = "your-subject")
    private WebElement contactFormSubject;

    @FindBy(name = "your-message")
    private WebElement contactFormMessage;

    @FindBy(xpath = ".//*[@value = 'var 1']")
    private WebElement checkboxVar1;

    @FindBy(xpath = ".//*[@value = 'var 2']")
    private WebElement checkboxVar2;

    @FindBy(xpath = ".//*[@value = 'var 3']")
    private WebElement checkboxVar3;

    @FindBy(xpath = ".//input[@class='wpcf7-form-control wpcf7-submit' and @type='submit']")
    private WebElement submitButton;

    public ContactFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openContactFormPage(){open("https://45.77.53.253/contacts/");}

    public void enterClientNameInContactForm(String clientName){
        actionsWithOurElements.enterText(clientNameField, clientName);
    }

    public void enterClientEmailInContactForm(String clientEmail){
        actionsWithOurElements.enterText(clientEmailField, clientEmail);
    }

    public void selectClientCityFromDDByName(String nameOfCity){
        actionsWithOurElements.selectTextInDDByText(clientCityDD, nameOfCity);
    }

    public void enterSubjectIntoContactForm(String subject){
        actionsWithOurElements.enterText(contactFormSubject, subject);
    }

    public void enterMessageIntoContactForm(String message){
        actionsWithOurElements.enterText(contactFormMessage, message);
    }

    public void checkingCheckboxVar1(){
        actionsWithOurElements.checkCheckbox(checkboxVar1);
    }

    public void checkingCheckboxVar2(){
        actionsWithOurElements.checkCheckbox(checkboxVar2);
    }

    public void checkingCheckboxVar3(){
        actionsWithOurElements.checkCheckbox(checkboxVar3);
    }

    public void clickOnSubmitButton(){
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public boolean isElementWithTextPresent(String message){
       return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+message+"')]");
    }

    public boolean checkErrorMessageForClientNameField(String text){
        return actionsWithOurElements.checkTextInElementBoolean(".//span[@class='wpcf7-form-control-wrap your-name']//span[@class='wpcf7-not-valid-tip']", text);
    }

    public boolean checkErrorMessageForClientEmailField(String text){
        return actionsWithOurElements.checkTextInElementBoolean(".//span[@class ='wpcf7-form-control-wrap your-email']//span[@class='wpcf7-not-valid-tip']", text);
    }

    public boolean checkErrorMessageForClientCityDD(String text){
        return actionsWithOurElements.checkTextInElementBoolean(".//span[@class= 'wpcf7-form-control-wrap menu-539']//span[@class='wpcf7-not-valid-tip']", text);
    }


}
