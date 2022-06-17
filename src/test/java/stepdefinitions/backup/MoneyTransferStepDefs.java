package stepdefinitions.backup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import pages.backup.CommonPageElements;
import pages.backup.MoneyTransferPage;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class MoneyTransferStepDefs {
    CommonPageElements commonPageElements = new CommonPageElements();
    MoneyTransferPage moneyTransferPage = new MoneyTransferPage();
    @Given("user clicks on my operations")
    public void user_clicks_on_my_operations() {
//        commonPageElements.myOperations.click();
//        Clicking using custom wait
//        Driver.waitAndClick(commonPageElements.myOperations,10);
        Driver.waitAndClick(commonPageElements.myOperations);
    }
    @Given("user clicks on transfer money")
    public void user_clicks_on_transfer_money() {
//        commonPageElements.moneyTransferOption.click();
        Driver.waitAndClick(commonPageElements.moneyTransferOption);

    }
    @When("user select the current account to transfer money from")
    public void user_select_the_current_account_to_transfer_money_from() {
        Driver.wait(1);
        Driver.selectByIndex(moneyTransferPage.transferFrom,1);

    }
    @When("user select the other account to transfer money to")
    public void user_select_the_other_account_to_transfer_money_to() {
        Driver.selectByIndex(moneyTransferPage.transferTo,1);
    }
    @When("user provides the balance {string}")
    public void user_provides_the_balance(String string) {
        Driver.waitAndSendText(moneyTransferPage.balance,string);//DOLLAR AMOUNT
        Driver.waitAndSendText(moneyTransferPage.balanceCent,"2");//CENT AMOUNT
    }
    @When("user types the description")
    public void user_types_the_description() {
        Driver.waitAndSendText(moneyTransferPage.description,"Transferring between my accounts");
    }
    @Then("user makes the money transfer and verify success message")
    public void user_makes_the_money_transfer_and_verify_success_message() throws IOException {
        Driver.waitAndClick(moneyTransferPage.makeTransferButton);
        Driver.wait(1);
        Assert.assertTrue(moneyTransferPage.successMessageToastContainer.isDisplayed());
        System.out.println(moneyTransferPage.successMessageToastContainer.getText());
//        taking the screenshot of the success message
        File successImage = moneyTransferPage.successMessageToastContainer.getScreenshotAs(OutputType.FILE);
        File path = new File("successMessage.png");
        FileUtils.copyFile(successImage,path);

    }

}
