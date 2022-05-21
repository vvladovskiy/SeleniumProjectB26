package com.cydeo.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase03Positive {
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
        password.sendKeys("UserUser");
        Thread.sleep(1000);
        // Click on Log In button
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        Thread.sleep(1000);


        // Verify the username is "Part2 Group2"
        WebElement loginPage = driver.findElement(By.id("user-name"));
        if(loginPage.getText().equals("Part2 Group2")){
            System.out.println("Customer is logged in");
        }else{
            System.out.println("Login is failed");
        }

        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
