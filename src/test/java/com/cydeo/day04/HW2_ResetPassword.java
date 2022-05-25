package com.cydeo.day04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;

/*
TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
 */
public class HW2_ResetPassword {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Dimension dimension = new Dimension(1200, 1000);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement Login = driver.findElement(By.cssSelector(".login-inp"));
        Login.sendKeys("incorrect" + Keys.ENTER);

        WebElement resetPassword = driver.findElement(By.cssSelector(".login-btn"));
        resetPassword.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".errortext"));

        String expectedErrorMessage = "Login or E-mail not found";

        if (expectedErrorMessage.equals(errorMessage.getText())) {
            System.out.println("Test pass!");

        }else System.out.println("Test fail :(");

        driver.quit();
    }
}