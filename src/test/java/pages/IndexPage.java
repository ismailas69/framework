package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IndexPage {

    public IndexPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//input[@placeholder='Filter by keyword']")
    public WebElement keywordSearchBox;


    @FindBy(xpath="//a[@class='screener-table__link']")
    public List<WebElement> indexNamesList;

    @FindBy(xpath = "(//select[@class='mds-select__input__mds-nuxt'])[2]")
    public WebElement showDropdown;

    @FindBy(xpath = "//div[@class='mds-pagination__viewing-info__mds-nuxt']")
    public WebElement showpageOfpage;


}
