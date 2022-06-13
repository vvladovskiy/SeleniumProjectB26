package com.cydeo.testcases;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.VytrackLoginUtils;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase04VytrackDriver extends TestBase {

    @Test
    @Name("AC1. A truck driver should be able to see all Vehicle information once navigating to the Vehicle page.")

    public void DriverVytrackApplication() {

        driver.navigate().to("https://qa3.vytrack.com/user/login");

        WebElement loginTitlePage = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/h2"));
        loginTitlePage.getText();
        String actualLoginTitle = loginTitlePage.getText();
        String expectedLoginTitle = "Login";
        assertEquals(actualLoginTitle, expectedLoginTitle, "Step 1 failed!");

        VytrackLoginUtils.vytrackLogin(driver, "user4", "UserUser123");
        WebElement loginFleetPage = driver.findElement(By.xpath("//*[@id=\"organization-switcher\"]/div/h1/a"));
        loginFleetPage.getText();
        String actualFleetTitle = loginFleetPage.getText();
        String expectedFleetTitle = "FLEET MANAGEMENT";
        assertEquals(actualFleetTitle, expectedFleetTitle, "Step 2 failed!");

        WebElement fleetManu = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        fleetManu.getText();
        String actualFleet1Title = fleetManu.getText();
        String expectedFleet1Title = "Fleet";
        assertEquals(actualFleet1Title, expectedFleet1Title, "Step 3 failed!");

//        WebElement vehicleManu = driver.findElement(By.xpath("//*[@id=\"grid-custom-entity-grid-765093490\"]/div[2]/div[2]"));
//        fleetManu.click();
//        if(vehicleManu.isDisplayed()){
//          System.out.println("Done!");
//      }else System.out.println("not!");


//        driver.getTitle();
//        String actualvehicleTitle = driver.getTitle();
//        String expectedvehicleTitle = "Dashboard";// "Car - Entities - System - Car - Entities - System";
//        assertEquals(actualvehicleTitle, expectedvehicleTitle, "Step 4 failed!");

    }
}