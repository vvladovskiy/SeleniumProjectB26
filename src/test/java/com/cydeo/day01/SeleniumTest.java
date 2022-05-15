package com.cydeo.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        // 1- Setting up WebDriver manager
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of Chrome driver
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
    }
}
