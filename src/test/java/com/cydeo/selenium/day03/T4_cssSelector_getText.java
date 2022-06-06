package com.cydeo.selenium.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password



PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */
public class T4_cssSelector_getText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        Dimension dimension = new Dimension(1200, 1216);
        driver.manage().window().setSize(dimension);
        Thread.sleep(2000);
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");
        Thread.sleep(2000);

        WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetBtnText = "Reset password";
        String actualResetBtnText = resetPasswordBtn.getText();

        if (actualResetBtnText.equals(expectedResetBtnText)) {
            System.out.println("Reset button text verification passed!");
        } else {
            System.out.println("Reset button text verification failed!");
        }
        driver.quit();


    }

}
