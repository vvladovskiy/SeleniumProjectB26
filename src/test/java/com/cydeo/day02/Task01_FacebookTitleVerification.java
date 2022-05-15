package com.cydeo.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01_FacebookTitleVerification {
    public static void main(String[] args) {
        System.out.println(checkTitle("Check if Expected Title equal Actual!"));
    }
    public static String checkTitle(String str){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://facebook.com");

        String expectedTitle = "Facebook - log in or sign up";
        String actual = driver.getTitle();

        driver.close();
        driver.quit();

        if (expectedTitle.equals(actual)) {
            return "expected Title: " + "\""+expectedTitle+"\"" + " equal: " + "\""+actual+"\"";
        } else {
            return "expected Title: " + "\""+expectedTitle+"\"" + " not equal: " + "\""+actual+"\"";
        }
    }
}
