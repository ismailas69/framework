import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import java.util.*;

import java.time.Duration;
import java.util.ArrayList;

public class DynamicWebTable {
    WebDriver driver;
    @Test
    public  void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://indexes.morningstar.com/our-indexes");
        List<String> actualTabs = new ArrayList<>();
        List<String> expectedTabs = new ArrayList<>();
        expectedTabs.add("All Indexes");
        expectedTabs.add("Equity");
        expectedTabs.add("Fixed Income");
        expectedTabs.add("Multi Asset");
        expectedTabs.add("Alternatives");
        expectedTabs.add("ESG");
        System.out.println("Expected tabs: " + expectedTabs);

        List<WebElement> tabs = driver.findElements(By.xpath("//li[@role='tab']"));
        for (WebElement tab : tabs) {
            actualTabs.add(tab.getText());
        }
        System.out.println("Actual tabs: " + actualTabs);
        Assert.assertEquals("Tabs list doesn't match! ", expectedTabs, actualTabs);
    }
    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://indexes.morningstar.com/our-indexes");

        WebElement cookieAccept= driver.findElement(By.xpath("//button[@id='_evidon-accept-button']"));
        cookieAccept.click();

        /*for (int i = 1; i <=6 ; i++) {
            WebElement clicks = driver.findElement(By.xpath("(//span[@class='mds-checkbox__text__mds-nuxt'])["+i+"]"));
            boolean b = clicks.isSelected();
            if(!b){
                clicks.click();
            }

         */
       List<WebElement>checkboxes= driver.findElements(By.xpath("//span[@class='mds-checkbox__text__mds-nuxt']"));
        for (WebElement chkbox:checkboxes) {
            String value = chkbox.getText();
            //System.out.println(value);
            if (value.contains("Multi Asset")||value.contains("Fixed Income"))
            {
                chkbox.click();
        }

        }
//        driver.findElement(By.xpath("(//span[@class='mds-icon__mds-nuxt mds-icon--small__mds-nuxt mds-combo-box__open-icon__mds-nuxt'])[2]")).click();
//        Thread.sleep(1000);
//        WebElement geoRegions = driver.findElement(By.xpath("//li[@id='mds-combo-box__descendent-1']"));
//        System.out.println(geoRegions.getText());
        List<WebElement> geoLocation = driver.findElements(By.xpath("//li[@role='option']"));
        List<String> geoLocations=new ArrayList<>();

        for (WebElement w:geoLocation) {
            ReusableMethods.waitFor(1);
            w.click();
            geoLocations.add(w.getText());
        }
        System.out.println(geoLocations);
    }

    @Test
    public  void test1() {
        long start = System.currentTimeMillis();
        driver.findElement(By.xpath("//input[@placeholder='Filter by keyword']")).sendKeys("focus", Keys.ENTER);
            long finish = System.currentTimeMillis();
            long totalTime=finish-start;
        System.out.println("Page load time (milliseconds): "+totalTime);

        ReusableMethods.waitFor(1);
        String total_pages = driver.findElement(By.xpath("//div[contains(text(),'Page')]")).getText();
        int searchTotalPages = Integer.valueOf(total_pages.substring((total_pages.indexOf("of")) + 2).trim());
        System.out.println("Total # pages of search result: " + searchTotalPages);

        int count=0;

        for (int p = 1; p <= searchTotalPages; p++) {
            WebElement selectPages = driver.findElement(By.xpath("//select[@class='mds-select__input__mds-nuxt']"));
            Select pages = new Select(selectPages);
            pages.selectByValue(""+p+"");
            ReusableMethods.waitFor(2);
            int rows = driver.findElements(By.xpath("//tbody/tr")).size();
            System.out.println("Number of rows: " + rows);

            for (int r = 1; r <=rows ; r++) {
                String OurIndexes = driver.findElement(By.xpath("//tbody/tr["+r+"]/td[1]")).getText();
//                System.out.println("Our indexes: "+" #:"+r+" "+ OurIndexes);
                String indexFamily = driver.findElement(By.xpath("//tbody/tr["+r+"]/td[2]")).getText();
                if (indexFamily.contains("Equity")){
                    System.out.println("Our indexes: "+" #:"+r+" "+ indexFamily);
                    count++;
                }
            }
        }
                    System.out.println("Number of Equity: "+count);
    }
}