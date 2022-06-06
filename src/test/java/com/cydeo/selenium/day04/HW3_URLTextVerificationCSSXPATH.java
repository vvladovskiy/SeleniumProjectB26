package com.cydeo.selenium.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC #3: Practice Cydeo/ForgotPassword URL verification
 * 1. Open Chrome browser
 * 2. Go to http://practice.cydeo.com/forgot_password
 * 3. Enter any email into input box
 * 4. Click on Retrieve password
 * 5. Verify URL contains:
 * Expected: “email_sent”
 * 6. Verify textbox displayed the content as expected.
 * Expected: “Your e-mail’s been sent!”
 * <p>
 * Hint: You need to use getText method for this practice.
 */
public class HW3_URLTextVerificationCSSXPATH {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);

        driver.navigate().to("http://practice.cydeo.com/forgot_password");

//   WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailInputBox.sendKeys("test@test.com");

        //WebElement retrievePassword = driver.findElement(By.cssSelector("#form_submit"));
        //                                                       button[id='form_submit']>i;
        //                                                             button#form_submit>i;
        WebElement retrievePassword = driver.findElement(By.xpath("//*[@id='form_submit']"));
        //                               (By.xpath("//button[@id='form_submit']/i")).click();
        retrievePassword.click();

        String expectedURLTitle = "Email sent!";

        if (expectedURLTitle.equals(driver.getTitle())) {  // driver.getCurrentUrl()
            System.out.println("url pass");
        } else {
            System.out.println("url fail");
        }

 //    WebElement textBoxCss = driver.findElement(By.cssSelector("[name='confirmation_message']"));
        WebElement textBoxCss = driver.findElement(By.xpath("//h4[@name='confirmation_message']"));

        String textBox = "Your e-mail's been sent!";

        if(textBoxCss.isDisplayed()){
            System.out.println("textBoxCss.isDisplayed() = " + textBoxCss.isDisplayed());
        }

        if (textBoxCss.isDisplayed()&&textBox.equals(textBoxCss.getText())) {
            System.out.println("textbox pass");
        } else {
            System.out.println("textbox fail");
      }
        driver.quit();
    }
}
