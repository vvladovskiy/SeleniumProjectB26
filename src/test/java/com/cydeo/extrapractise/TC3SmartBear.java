package com.cydeo.extrapractise;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3SmartBear extends TestBase {

    @Test
    public void testSmartBear3() {

        driver.navigate().to(ConfigurationReader.getProperty("env"));
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        driver.findElement(By.xpath("//*[@id='ctl00_menu']/li[1]/a")).click();


        WebElement orderDataActual = driver.findElement(By.xpath("//*[.='01/05/2010']"));

        //*[@id="ctl00_MainContent_orderGrid"]/tbody/tr[6]/td[5]
        //*[.='01/05/2010']

        Assert.assertEquals(orderDataActual.getText(),"01/05/2010","Nop!");


    }
}
