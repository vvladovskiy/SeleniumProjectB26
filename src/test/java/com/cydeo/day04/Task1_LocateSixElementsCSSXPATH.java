package com.cydeo.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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

        WebElement emailInputBox1 = driver.findElement(By.cssSelector("[name='email']"));
        WebElement emailInputBox2 = driver.findElement(By.cssSelector("#forgot_password>div>div>[name ='email']"));
        WebElement emailInputBox3 = driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input"));
        //WebElement emailInputBox4 = driver.findElement(By.xpath(""));

        WebElement retrievePasswordButton1 = driver.findElement(By.cssSelector("#form_submit"));
        WebElement retrievePasswordButton2 = driver.findElement(By.cssSelector(".radius"));
        //WebElement retrievePasswordButton3 = driver.findElement(By.xpath("//input[starts-with(@pattern,'a-z')]"));
        //WebElement retrievePasswordButton4 = driver.findElement(By.xpath(""));

        WebElement poweredByCydeoText1 = driver.findElement(By.cssSelector("#page-footer > div > div"));

        WebElement poweredByCydeoText3 = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div"));
        //WebElement poweredByCydeoText4 = driver.findElement(By.xpath(""));


        System.out.println("emailInputBox1.isDisplayed() = " + emailInputBox1.isDisplayed());
        System.out.println("retrievePasswordButton1.isDisplayed() = " + retrievePasswordButton1.isDisplayed());
        System.out.println("poweredByCydeoText1.isDisplayed() = " + poweredByCydeoText1.isDisplayed());


        driver.quit();

    }
}
