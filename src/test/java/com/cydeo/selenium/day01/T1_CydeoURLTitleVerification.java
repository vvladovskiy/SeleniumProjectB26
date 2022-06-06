package com.cydeo.selenium.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoURLTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String expectedURL = "https://practice.cydeo.com/";
        String actualURL = driver.getCurrentUrl();
        System.out.println(expectedURL);

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification is passed!");
        }else{
            System.out.println("URL verification is failed!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification passed!");
        }else {
            System.out.println("Title verification failed!");
        }


        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }}
