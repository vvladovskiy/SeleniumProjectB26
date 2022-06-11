package com.cydeo.selenium.day08_alert;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //        1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void confirmAlertTest() throws InterruptedException {

//        3. Click to “Click for JS Confirm” button
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBtn.click();

        Thread.sleep(3000);

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        // for clicking OK button in JS alert we are using accept() method
        alert.accept();

        Thread.sleep(3000);

        // for clicking cancel button in JS alert we are using dismiss() method
        //alert.dismiss();

//        5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));
        assertTrue(resultText.isDisplayed(),"result text did not appear!");

        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";
        assertEquals(actualText,expectedText,"result text did not appear correctly!");


        //Assert.assertEquals(resultText.getText(),"You clicked: Ok");

    }

    @Test
    public void promptAlerttest() throws InterruptedException {

//        3. Click to “Click for JS Prompt” button
         WebElement jsPrompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]"));
         jsPrompt.click();

//        4. Send “hello” text to alert
         Alert alert = driver.switchTo().alert();
         // Alert alert1 = driver.switchTo().alert();
         alert.sendKeys("hello");

         Thread.sleep(3000);
//        5. Click to OK button from the alert
          alert.accept();

        Thread.sleep(3000);

//        6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));
        assertTrue(resultText.isDisplayed(),"result text did not appear!");

        String actualText = resultText.getText();
        String expectedText = "You entered: hello";
        assertEquals(actualText,expectedText,"result text did not appear correctly!");

    }




    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }





}
