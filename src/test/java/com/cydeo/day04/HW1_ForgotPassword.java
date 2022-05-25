package com.cydeo.day04;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
 */
public class HW1_ForgotPassword {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);
        driver.navigate().to("https://login1.nextbasecrm.com/");

        WebElement rememberMeCheckBox = driver.findElement(By.cssSelector(".login-item-checkbox-label"));

        String expectedRememberMeCheckBoxName = "Remember me on this computer";

        if (expectedRememberMeCheckBoxName.equals(rememberMeCheckBox.getText()))
            System.out.println("Remember test pass!");
        else System.out.println("Remember test fail :(");

        WebElement forgotPasswordLinkText = driver.findElement(By.cssSelector(".login-link-forgot-pass"));

        String expectedForgotLinkText = "FORGOT YOUR PASSWORD?";

        if (expectedForgotLinkText.equals(forgotPasswordLinkText.getText())) System.out.println("Forgot test pass!");
        else System.out.println("Forgot test fail :(");
//-------------------------------
        WebElement forgotPasswordHrefAttrBValue = driver.findElement(By.cssSelector("a[href='/?forgot_password=yes']"));

        String expectedForgotPasswordHrefAttrBValue = "https://login1.nextbasecrm.com/?forgot_password=yes";

        if (expectedForgotPasswordHrefAttrBValue.equals(forgotPasswordHrefAttrBValue.getAttribute("href"))){
            System.out.println("Forgot value test pass!");
        }
        else{
            System.out.println("Forgot value test fail :(");
        }


        driver.quit();
    }
}
