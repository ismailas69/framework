package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.IndexPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Dropdown {
    IndexPage indexPage=new IndexPage();


        @When("user select value {string} show number of index per page dropdown")
        public void user_select_value_show_number_of_index_per_page_dropdown(String value) {

        WebElement element= indexPage.showDropdown;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Select dropdown = new Select(element);
        System.out.println(value);
        dropdown.selectByVisibleText(value);

        ReusableMethods.waitFor(5);
        String[] array = indexPage.showpageOfpage.getText().split(" ");
        System.out.println(array[3]);

        if(Integer.parseInt(array[5])>=Integer.parseInt(value)){
                Assert.assertEquals(value,array[3]);
        }

    }
}
