package com.cydeo.extrapractise;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static com.cydeo.utilities.SmartBearUtils.loginToSmartBear;

public class SmartBear extends TestBase {

    // TC #1: Smartbear software link verification

    @Test
    public void testSmartbear() throws InterruptedException {


        loginToSmartBear(driver);

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

//        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//
//        //3. Enter username: “Tester”
//        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
//
//        //4. Enter password: “test”
//        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
//
//        //5. Click to Login button
//        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();


        //6. Print out count of all the links on landing page

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getAttribute("href"));
        }

        //7. Print out each link text on this page
        System.out.println("driver.findElement(By.linkText(\"View all orders\")) = " + driver.findElement(By.linkText("View all orders")));
        System.out.println("driver.findElement(By.linkText(\"View all products\")) = " + driver.findElement(By.linkText("View all orders")));
        System.out.println("driver.findElement(By.linkText(\"Order\")) = " + driver.findElement(By.linkText("View all orders")));


// elem.getAttribute("innerHTML");


        //Mini-Task: CREATE A CLASSàSmartBearUtils
        //• Create a method called loginToSmartBear
        //• This method simply logs in to SmartBear when you call it.
        //• Accepts WebDriver type as parameter


        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button


        //6. Click on Order
        WebElement order1 = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[13]/input"));
        order1.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));

        // wrap this element inside Select object
        Select dropdownName = new Select(dropdown);

        dropdownName.selectByVisibleText("FamilyAlbum");
        dropdownName.selectByIndex(1);   //  0 1 2
        dropdownName.selectByValue("FamilyAlbum");

        dropdownName.getOptions().get(0); // all options -> List of WebElements
        dropdownName.getFirstSelectedOption().getText(); // currently selected -> WebElement
        dropdownName.getAllSelectedOptions().get(0); // all selected options -> List of WebElements

        System.out.println(dropdownName.getOptions().get(0)); // all options -> List of WebElements
        System.out.println(dropdownName.getFirstSelectedOption().getText()); // currently selected -> WebElement
        System.out.println(dropdownName.getAllSelectedOptions().get(0)); // all selected options -> List of WebElements


        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/ol[1]/li[5]/input[2]"));


        //9. Fill address Info with JavaFaker


        //• Generate: name, street, city, state, zip code
        //10. Click on “visa” radio button
        //11. Generate card number using JavaFaker
        //12. Click on “Process”
        //13.Verify success message “New order has been successfully added.”
    }
}