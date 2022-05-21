package com.cydeo.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */
public class T2_WoodenSpoonEtsy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200,1216);
        driver.manage().window().setSize(dimension);
        driver.navigate().to("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Done!");
        }else System.out.println("nop");

        driver.quit();


    }
    }

