package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "My Account")
    public WebElement myAccountMenu;


    @FindBy(linkText = "Login")
    public WebElement loginDropdown;

    @FindBy(linkText = "Register")
    public WebElement registerDropdown;



}
