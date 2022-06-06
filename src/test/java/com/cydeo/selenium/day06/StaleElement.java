package com.cydeo.selenium.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #6: StaleElementReferenceException Task

1. Open a chrome browser
2. Go to: https://practice.cydeo.com/abtest
3. Locate “CYDEO” link, verify it is displayed.
4. Refresh the page.
5. Verify it is displayed, again.

There are 2 situations that we can get this exception:
1- navigation (handle with reassingn(relocate) the element)
2- when element deleted from both html and page (handle with try catch)
This practice is about when navigation refresh happens sometime you can receive this exception and we should know how to handle it with relocating

relocating means; you will find element again;
cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));

 */
public class StaleElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);

driver.get("https://practice.cydeo.com/abtest");

        WebElement nameCydeo = driver.findElement(By.cssSelector("[href='https://cydeo.com/']"));
        System.out.println("linkCydeo.isDisplayed() = " + nameCydeo.isDisplayed());


        driver.navigate().refresh();



        try {

            System.out.println("After refreshing page " + nameCydeo.isDisplayed());

        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("This means the web element modified");
        }

        //System.out.println("linkCydeo.isDisplayed() = " + nameCydeo.isDisplayed());

        WebElement end =  driver.findElement(By.xpath("//*[text()='CYDEO']"));
        System.out.println(end);


        driver.close();
        driver.quit();


    }
}
