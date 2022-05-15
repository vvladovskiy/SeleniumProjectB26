package com.cydeo.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(checkTitle("Check if Expected Title equal Actual!"));
    }
    public static String checkTitle(String str) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://facebook.com");

        String expectedTitle = "Facebook - log in or sign up";
        String actual = driver.getTitle();

        Thread.sleep(2000);

        driver.close();
        driver.quit();

        if (expectedTitle.equals(actual)) {
            return "expected Title: " + "\""+expectedTitle+"\"" + " equal: " + "\""+actual+"\"";
        } else {
            return "expected Title: " + "\""+expectedTitle+"\"" + " not equal: " + "\""+actual+"\"";
        }
    }
}
