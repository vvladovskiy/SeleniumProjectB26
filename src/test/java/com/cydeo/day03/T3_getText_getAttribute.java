package com.cydeo.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getText_getAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200,1216);
        driver.manage().window().setSize(dimension);

        driver.get("https://practice.cydeo.com/registration_form");

        WebElement headerText = driver.findElement(By.cssSelector("div.page-header>h2"));

        String expectedHeader = "Registration form";
        String actualResult = headerText.getText();

        if(actualResult.equals(expectedHeader)){
            System.out.println("Header Text Verification pass!");
        }else System.out.println("Header Text Verification fail!");

        WebElement firstNAmeInput = driver.findElement(By.className("form-control"));

        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNAmeInput.getAttribute("placeholder");

        if(actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder text verification passed!");
        }else{
            System.out.println("Placeholder text verification failed!");
        }

    }
}
