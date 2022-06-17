package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountLoginPage {

    public AccountLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[(text()='Returning Customer')]")
    public WebElement returningCustomerMessage;
    @FindBy(id="input-email")
    public WebElement emailTextbox;
    @FindBy(id="input-password")
    public WebElement passTextbox;
    @FindBy(xpath="//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[(text()=' Warning: No match for E-Mail Address and/or Password.')]")
    public WebElement WarningMessage;
    @FindBy(xpath = "//*[(text()='Forgotten Password')]")
    public WebElement forgottenPassword;

}