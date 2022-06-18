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

public class TC1_2SmartBear extends TestBase {

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
        //• Generate: name, street, city, state, zip code

        Faker faker = new Faker();

        WebElement Qua = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
        Qua.clear();
        Qua.sendKeys(faker.numerify("2"));

        WebElement name = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtName']"));
        name.sendKeys(faker.name().fullName());

        //System.out.println("faker.name().firstName() = " + faker.name().firstName());
        //System.out.println("faker.name().lastName() = " + faker.name().lastName());

        WebElement address = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        address.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys(faker.address().city());

        WebElement zip = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        zip.sendKeys(faker.numerify("98040"));


        //10. Click on “visa” radio button
        WebElement visa = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visa.click();

        //11. Generate card number using JavaFaker

        WebElement card = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        card.sendKeys(faker.numerify("123412341234"));

        WebElement data = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        data.sendKeys(faker.numerify("12/22"));

        //12. Click on “Process”
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

        //13.Verify success message “New order has been successfully added.”
        WebElement actual1 = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/div/strong"));

        //"New order has been successfully added.", "Test failed"
        Assert.assertEquals(actual1.getText(), "New order has been successfully added.", "Test failed");

    }
}