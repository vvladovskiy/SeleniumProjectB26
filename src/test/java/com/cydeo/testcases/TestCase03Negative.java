package com.cydeo.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase03Negative {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://login2.nextbasecrm.com");

        // Enter valid username provided: "helpdesk3@cybertekschool.com"
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("helpdesk3@cybertekschool.com");
        Thread.sleep(1000);
        // Enter valid password provided: "UserUser"
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser0");
        Thread.sleep(1000);
        // Click on Log In button
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        Thread.sleep(1000);


        // Verify the message "Incorrect login or password"
        WebElement alert = driver.findElement(By.className("errortext"));

        // getText() method; it will get the content(text) form in between the opening and closing tag

        if(alert.getText().equals("Incorrect login or password")){
            System.out.println("Message appear");
        }else{
            System.out.println("Message is failed");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
