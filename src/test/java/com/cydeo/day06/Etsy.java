package com.cydeo.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results


 */
public class Etsy {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);

        driver.navigate().to("https://www.etsy.com");

        WebElement searchForWoodenSpoon = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchForWoodenSpoon.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement allFiltersButton = driver.findElement(By.xpath("//*[@id=\"search-filter-button\"]"));
        allFiltersButton.click();

        WebElement freeShipping = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[2]/fieldset/div/div/div[1]/div/label"));
        freeShipping.click();

        WebElement onSale = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[2]/fieldset/div/div/div[2]/div/label"));
        onSale.click();

        WebElement underTwentyFive = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[4]/fieldset/div/div/div[2]/label"));
        underTwentyFive.click();

        WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"search-filters-overlay\"]/div/div/div[2]/button[2]"));
        applyButton.click();

        Thread.sleep(600);

//        WebElement myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[7]/div[2]/div[1]/span/span/span[1]")));



        WebElement resultCount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[7]/div[2]/div[1]/span/span/span[1]"));
        System.out.println("resultCount.getText() = " + resultCount.getText());
//
//
//
//        WebElement myDynamicElement1 = (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        driver.close();
        driver.quit();


    }


//    @BeforeClass
//    public void setUp() {
//        WebDriver driver = new ChromeDriver();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        //driver.quit();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        //driver.get("https://www.etsy.com");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        //driver.close();
//    }
//
//    @Test
//    public void titleTest() {
//        //assertEquals(driver.getTitle(),"Etsy");
//    }
}
