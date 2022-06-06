package com.cydeo.selenium.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
 */
public class T1_BackAndForth {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        System.out.println(driver.manage().window().getSize());
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Dimension dimension = new Dimension(1200, 1216);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);
        driver.navigate().to("https://google.com");
        Thread.sleep(2000);

        WebElement gmailSign = driver.findElement(By.xpath("//div[@class='gb_e gb_f']//a[.='Gmail']"));
        gmailSign.click();

        Thread.sleep(2000);

        String actualTitle = driver.getTitle(); // actual title
        String expectedTitle = "Gmail: Free, Private";         // expected title
        System.out.println("Title of the page: " + actualTitle);


        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Gmail test passed! Expected Title: "+ expectedTitle + " ...");
        } else {
            System.out.println("Gmail test failed :(");
        }

        driver.navigate().back();

        Thread.sleep(2000);

        String actualTitle1 = driver.getTitle(); // actual title
        String expectedTitle1 = "Google";         // expected title
        System.out.println("Title of the page: " + actualTitle1);


        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("Google test passed! Expected Title: " + expectedTitle1);
        } else {
            System.out.println("Google test failed :(");
        }
        Thread.sleep(2000);

        driver.close();

    }
}
