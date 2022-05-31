package com.cydeo.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * XPATH and CSS Selector PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #1: XPATH and cssSelector Practices
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/forgot_password
 * 3. Locate all the WebElements on the page using XPATH and/or CSS
 * locator only (total of 6)
 * a. “Home” link
 * b. “Forgot password” header
 * c. “E-mail” text
 * d. E-mail input box
 * e. “Retrieve password” button
 * f. “Powered by Cydeo text
 * 4. Verify all web elements are displayed.
 * First solve the task with using cssSelector only. Try to create 2 different
 * cssSelector if possible
 * <p>
 * Then solve the task using XPATH only. Try to create 2 different
 * XPATH locator if possible
 */
public class Task1_LocateSixElementsCSSXPATH {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);

        driver.navigate().to("https://practice.cydeo.com/forgot_password");

        System.out.println((driver.findElement(By.cssSelector(".nav-link")).isDisplayed() == true) ? "\"Home\"" + " link are displayed! css1" : "\"Home\"" + " link NOT displayed! css1");
        System.out.println((driver.findElement(By.cssSelector("a[href='/']")).isDisplayed() == true) ? "\"Home\"" + " link are displayed! css2" : "\"Home\"" + " link NOT displayed! css2");
        System.out.println((driver.findElement(By.xpath("//a[@class='nav-link']")).isDisplayed() == true) ? "\"Home\"" + " link are displayed! xpath1" : "\"Home\"" + " link NOT displayed! xpath1");
        System.out.println((driver.findElement(By.xpath("//a[.='Home']")).isDisplayed() == true) ? "\"Home\"" + " link are displayed! xpath2" : "\"Home\"" + " link NOT displayed! xpath2");

        System.out.println((driver.findElement(By.cssSelector("div[id='content']>div>h2")).isDisplayed() == true) ? "\"Forgot Password\"" + " header displayed! css1" : "\"Forgot Password\"" + " header NOT displayed! css1");
        System.out.println((driver.findElement(By.cssSelector("div[class = 'example']>h2")).isDisplayed() == true) ? "\"Forgot Password\"" + " header displayed! css2" : "\"Forgot Password\"" + " header NOT displayed! css2");
        System.out.println((driver.findElement(By.xpath("//*[@class='example']/h2")).isDisplayed() == true) ? "\"Forgot Password\"" + " header displayed! xpath1" : "\"Forgot Password\"" + " header NOT displayed! xpath1");
        System.out.println((driver.findElement(By.xpath("//div[starts-with(@id, 'cont')]/div/h2")).isDisplayed() == true) ? "\"Forgot Password\"" + " header displayed! xpath2" : "\"Forgot Password\"" + " header NOT displayed! xpath2");

        System.out.println((driver.findElement(By.cssSelector("#forgot_password > div > div > label")).isDisplayed() == true) ? "\"E-mail\"" + " text displayed! css1" : "\"E-mail\"" + " text NOT displayed! css1");
        System.out.println((driver.findElement(By.cssSelector(".row>div>label")).isDisplayed() == true) ? "\"E-mail\"" + " text displayed! css2" : "\"E-mail\"" + " text NOT displayed! css2");
        System.out.println((driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/label")).isDisplayed() == true) ? "\"E-mail\"" + " text displayed! xpath1" : "\"E-mail\"" + " text NOT displayed! xpath1");
        System.out.println((driver.findElement(By.xpath("//*[@name='forgot_password']/div/div/label")).isDisplayed() == true) ? "\"E-mail\"" + " text displayed! xpath2" : "\"E-mail\"" + " text NOT displayed! xpath2");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.quit();

    }
}
