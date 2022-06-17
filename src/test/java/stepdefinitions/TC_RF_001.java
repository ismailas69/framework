package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.IndexPage;
import utilities.ReusableMethods;
import java.util.List;


public class TC_RF_001 {
    IndexPage indexPage = new IndexPage();
    @Given("user navigates to Morningstar")
    public void user_navigates_to_morningstar() {

    }
    @When("user sends keyword {string} to keyword search box")
    public void user_sends_keyword_to_keyword_search_box(String string) {
     indexPage.keywordSearchBox.sendKeys(string);
    }
    @When("user clicks on enter button")
    public void user_clicks_on_enter_button() {
        indexPage.keywordSearchBox.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);
    }

    @Then("user should be able to see {string} in all Index Name field")
    public void user_should_be_able_to_see_in_all_index_name_field(String string) {
        List<WebElement> indexNamesList = indexPage.indexNamesList;
            boolean result= false;
            for(WebElement each:indexNamesList){
            result = each.getText().toLowerCase().contains(string);

            }
            System.out.println("result: "+result);
                if(indexNamesList.isEmpty()){
            Assert.assertFalse(result);
                }else{
            Assert.assertTrue(result);
             }

    }
}
