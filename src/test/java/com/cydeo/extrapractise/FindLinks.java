package com.cydeo.extrapractise;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindLinks {
    /*
    TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 337*/

    @Test
    public void testTC1() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        assertEquals(links.size(), 337, "test failed");
        Driver.closeDriver();
    }

/*TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page*/

    @Test
    public void testTC2() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        List<String> linkText = new ArrayList<>();
        for (int i = 0; i < allLinks.size(); i++) {
            try {
                linkText.add(allLinks.get(i).getText());
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
        int hasTextCount = 0;
        for (int i = 0; i < allLinks.size(); i++) {
            if(!linkText.get(i).isBlank()&&!linkText.get(i).isEmpty()&&linkText.get(i)!=null){
                System.out.println("linkText.get(i) = " + linkText.get(i));
                hasTextCount++;
            }
        }
        System.out.println("Number of links which have visible text "+hasTextCount+".");
        Driver.closeDriver();
    }
    /*TC #3: Counting the number of links that does not have text
    1. Open Chrome browser
    2. Go to https://www.openxcell.com
    3. Count the number of links that does not have text and verify
    Expected: 109

    NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
    FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
    IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
    VERIFICATION.
         */
        @Test
        public void testTC3 () {
            Driver.getDriver().get(ConfigurationReader.getProperty("env2"));


            Driver.closeDriver();
        }
    }

