package com.cydeo.day04;

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
public class HW3_URLTextVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);

        driver.navigate().to("http://practice.cydeo.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));
        emailInputBox.sendKeys("vvladovskiy@gmail.com");

        Thread.sleep(2000);

        WebElement retrievePassword = driver.findElement(By.cssSelector("#form_submit"));
        retrievePassword.click();

        Thread.sleep(2000);

        String expectedURLTitle = "Email sent!";

        if (expectedURLTitle.equals(driver.getTitle())) {
            System.out.println("pass");
        } else {
            System.out.println("not pass");
        }
        Thread.sleep(5000);

        WebElement textBoxCss = driver.findElement(By.cssSelector("[name='confirmation_message']"));

        System.out.println(textBoxCss.getText());
        Thread.sleep(3000);
        String textBox = "Your e-mail’s been sent!";
        System.out.println(textBox);

        if (textBox.equals(textBoxCss.getText())) {
            System.out.println("text pass");
        } else {
            System.out.println("text not pass");
        }


        driver.quit();
    }
}
