package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
   public WebElement My_account;
    @FindBy(linkText = "Checkout")
    public WebElement CheckOutText;
    @FindBy(xpath= "(//*[text()='My Account'])[5]")
    public WebElement LogoutDropMenu;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    public WebElement logout;
    @FindBy(xpath = "(//*[(text()='Account Logout')])[2]")
    public WebElement AccountLogOutMessage;

}
