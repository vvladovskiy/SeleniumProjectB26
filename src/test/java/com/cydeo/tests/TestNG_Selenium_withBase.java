package com.cydeo.tests;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Selenium_withBase extends TestBase {



    @Test
    public void googleTitle() {

        driver.get("https://google.com");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Google Title not matching");


    }

}
