package com.cydeo.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
//        WebDriverManager.chromedriver().setup();

//        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(1200,1216);
        driver.manage().window().setSize(dimension);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
