package com.cydeo;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

// links for Alert Practices:   https://chercher.tech/practice/practice-pop-ups-selenium-webdriver
//                              https://demoqa.com/alerts
//                              http://practice.cydeo.com/javascript_alerts



public class AlertPractice {

  WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //        1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }



    @Test
    public void InformationAlertTest(){
//        3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

//        4. Click to OK button from the alert
       // driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        // if Alert comes from JS we use the Alert class
        alert.accept(); // --> click "Ok" on popup
        alert.dismiss(); // --> click "Cancel" on popup
        alert.getText();  // --> to get text from popup
        alert.sendKeys("text"); // --> to send text



//        5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));

       // asserTrue() method will check if inside argument is true or false
       Assert.assertTrue(resultText.isDisplayed(),"Result text did not displayed!");

       String actualResultText = resultText.getText();
       String expectedResultText ="You successfully clicked an alert";
       Assert.assertEquals(actualResultText,expectedResultText,"Result text did not appear correctly!");

    }
}
