package com.cydeo.extrapractise;

import com.cydeo.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
        WebElement order1 = driver.findElement(By.xpath("//*[@id='ctl00_menu']/li[3]/a"));
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

        Faker faker = new Faker();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        //System.out.println("faker.name().firstName() = " + faker.name().firstName());
        //System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().streetAddress() = " + faker.address().city());
        System.out.println("faker.address().streetAddress() = " + faker.address().state());
        System.out.println("faker.address().streetAddress() = " + faker.address().zipCode());



        //• Generate: name, street, city, state, zip code


        //10. Click on “visa” radio button
WebElement visa = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
visa.click();

        //11. Generate card number using JavaFaker
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.data() = " + faker.date());


        //12. Click on “Process”
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

        //13.Verify success message “New order has been successfully added.”
//        WebElement actual = driver.findElement(By.xpath("//strong"));
//        actual.isDisplayed();
//        System.out.println(actual);

        WebElement actual = driver.findElement(By.cssSelector("strong"));
        actual.getText();

      Thread.sleep(3000);

        Assert.assertEquals(actual,"New order has been successfully added.","Test failed");


    }
}