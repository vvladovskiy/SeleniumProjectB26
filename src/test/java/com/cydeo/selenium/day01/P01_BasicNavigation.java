package com.cydeo.selenium.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

//set up chrome and create WebDriver instance
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // navigate.to(url)
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        // driver.get(url)
        driver.get("https://www.tesla.com");

        // navigate.back()
        driver.navigate().back();

        Thread.sleep(3000);

        // navigate.forward()
        driver.navigate().forward();

        Thread.sleep(3000);

        // navigate.refresh()
        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.get("https://www.tesla.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        driver.close();
        driver.quit();
    }
}
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get();

        driver.navigate().to();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.getTitle();
        driver.getCurrentUrl());

        Thread.sleep(3000);

        driver.close();
        driver.quit();

 */
