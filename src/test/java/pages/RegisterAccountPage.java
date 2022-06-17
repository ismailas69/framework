package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterAccountPage {


    public RegisterAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="input-firstname")
    public WebElement firstNameBox;

    @FindBy(id ="input-lastname")
    public WebElement lastNameBox;

    @FindBy(id ="input-email")
    public WebElement emailBox;

    @FindBy(id ="input-telephone")
    public WebElement telephoneBox;


    @FindBy(id ="input-password")
    public WebElement passwordBox;

    @FindBy(id ="input-confirm")
    public WebElement confirmBox;

    @FindBy(xpath="(//input[@name = 'newsletter'])[1]")
    public WebElement yesnewsletter;

    @FindBy(xpath="(//input[@name = 'newsletter'])[2]")
    public WebElement nonewsletter;

    @FindBy(xpath="//input[@name = 'agree']")
    public WebElement policy;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath="//*[contains(text(),'Register Account')]")
    public WebElement registerAccountTitle;







}
