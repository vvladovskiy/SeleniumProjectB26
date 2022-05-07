package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_FullScreenMode {
    public static void main(String[] args) throws InterruptedException {

        //set up chrome and create WebDriver instance
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // navigate to Google and print out the title
        driver.get("http://cydeo.com");

        driver.manage().window().maximize();

//        driver.manage().window().fullscreen();

        Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
