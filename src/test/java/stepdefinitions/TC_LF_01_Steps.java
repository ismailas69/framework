package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountLoginPage;
import pages.AccountPage;
import pages.ForgottenPassword;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;

public class TC_LF_01_Steps {
    HomePage homePage=new HomePage();
    AccountLoginPage accountLoginPage = new AccountLoginPage();
    AccountPage accountPage = new AccountPage();
    ForgottenPassword forgottenPassword=new ForgottenPassword();

    @Given("user click on My Account dropdown")
    public void user_click_on_my_account_dropdown() {
    homePage.myAccountMenu.click();
    }
    @When("user click on My Account dropdown loggedin")
    public void user_click_on_my_account_dropdown_loggedin() {
    accountPage.My_account.click();
    }
    @Given("click on Login option")
    public void click_on_login_option() {
    homePage.loginDropdown.click();
    }
    @Then("validate user is on Login page")
    public void validate_user_is_on_login_page() throws IOException {
        Assert.assertTrue(accountLoginPage.returningCustomerMessage.isDisplayed());
        System.out.println(accountLoginPage.returningCustomerMessage.getText());
    }
    @When("user enters email {string}  and password {string}")
    public void user_enters_email_and_password(String email, String password) throws IOException {
    accountLoginPage.emailTextbox.sendKeys(email);
    accountLoginPage.passTextbox.sendKeys(password);
     ReusableMethods.getScreenshot("logged in");
    }
    @When("user click login button")
    public void user_click_login_button() {
    accountLoginPage.loginButton.click();
    }
    @Then("verify user logged in and taken to Account page")
    public void verify_user_logged_in_and_taken_to_account_page() throws IOException {
    homePage.myAccountMenu.click();
    ReusableMethods.getScreenshot("myAccountmenu");
    Assert.assertTrue(accountPage.LogoutDropMenu.isDisplayed());
        System.out.println(accountPage.LogoutDropMenu.getText());
        ReusableMethods.getScreenshot("Logout");
    }
    @Then("verify user cannot logged in and warning message visible")
    public void verify_user_cannot_logged_in_and_warning_message_visible() throws IOException {
        Assert.assertTrue(accountLoginPage.WarningMessage.isDisplayed());
        System.out.println(accountLoginPage.WarningMessage.getText());
        ReusableMethods.getScreenshot("loginwarning");
    }
    @Then("validate user is on Login page and forgotten password link is displayed")
    public void validate_user_is_on_login_page_and_forgotten_password_link_is_displayed() {
        Assert.assertTrue(accountLoginPage.forgottenPassword.isDisplayed());
        System.out.println(accountLoginPage.forgottenPassword.getText());
    }

    @When("user clicks on forgotten password link")
    public void user_clicks_on_forgotten_password_link() throws InterruptedException {
    accountLoginPage.forgottenPassword.click();
    Thread.sleep(300);
    }

    @Then("verify user is in forgotten password page")
    public void verify_user_is_in_forgotten_password_page() {
    Assert.assertTrue(forgottenPassword.forgotPageMessage.isDisplayed());
        System.out.println(forgottenPassword.forgotPageMessage.getText());
    }

    @Given("user navigates to emailtextbox by clicking Keys.tab")
    public void user_navigates_to_emailtextbox_by_clicking_keys_tab() throws InterruptedException {
   accountLoginPage.emailTextbox.sendKeys(Keys.TAB);
   Thread.sleep(500);

//    accountLoginPage.emailTextbox.sendKeys();
//    if(Driver.getDriver().switchTo().activeElement().equals(accountLoginPage.emailTextbox))
//        System.out.println("emailtextbox in focus");
//    else
//        System.out.println("assertion");
//    accountLoginPage.emailTextbox.sendKeys(Keys.TAB);
//        if(Driver.getDriver().switchTo().activeElement().equals(accountLoginPage.passTextbox))
//            System.out.println("passtextbox in focus");
//        else
//            System.out.println("assertion");
//        accountLoginPage.passTextbox.sendKeys(Keys.TAB);
    }
    @Given("user enters email {string}")
    public void user_enters_email(String string) {
        accountLoginPage.emailTextbox.sendKeys(string);
    }
    @Given("user navigates to passwordtextbox by clicking Keys.tab")
    public void user_navigates_to_passwordtextbox_by_clicking_keys_tab() throws InterruptedException {
        accountLoginPage.passTextbox.sendKeys(Keys.TAB);
        Thread.sleep(500);
    }
    @Given("user enters password {string}")
    public void user_enters_password(String string) throws InterruptedException {
        accountLoginPage.passTextbox.sendKeys(string);
        Thread.sleep(500);
    }
    @Given("user navigates to login button by clicking Keys.tab")
    public void user_navigates_to_login_button_by_clicking_keys_tab() throws InterruptedException {
        accountLoginPage.loginButton.sendKeys(Keys.TAB);
        Thread.sleep(500);
    }
    @Given("user click login button by Keys.Enter")
    public void user_click_login_button_by_keys_enter() {
       accountLoginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @Then("verify placeholder text in the email and address textbox")
    public void verify_placeholder_text_in_the_email_and_address_textbox() {
        String placeholderEmail = accountLoginPage.emailTextbox.getAttribute("placeholder");
        Assert.assertEquals("E-Mail Address", placeholderEmail);
        String placeholderPassword=accountLoginPage.passTextbox.getAttribute("placeholder");
        Assert.assertEquals("Password",placeholderPassword);
    }
    @When("user click on Browser back button")
    public void user_click_on_browser_back_button() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.history.back");
//        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
    }
    @Then("verify user not logged in and taken to Account page")
    public void verify_user_not_logged_in_and_taken_to_account_page() throws IOException {

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
//       ReusableMethods.waitForVisibility(accountPage.LogoutDropMenu,5);
       Assert.assertTrue(accountPage.LogoutDropMenu.isDisplayed());

        ReusableMethods.getScreenshot("Logout");
    }

    @When("user click logout button")
    public void user_click_logout_button() {
    accountPage.logout.click();
    }
    @Then("verify user not logged in again")
    public void verify_user_not_logged_in_again() {
    String accountLogoutMessage = "Account Logout";
    Assert.assertEquals(accountLogoutMessage,accountPage.AccountLogOutMessage.getText());
    }
}

