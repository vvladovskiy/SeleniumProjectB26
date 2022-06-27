package com.cydeo.extrapractise;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
Task #: Gas Mileage Calculator Automation Test
1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
    a. Title equals: “Gas Mileage Calculator”
    b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”
 */
public class GasMileageCalculatorTest {
    @Test
    public void testGasMileageCalc() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        Driver.getDriver().findElement(By.id("calcSearchTerm")).sendKeys("gas mileage");
        Driver.getDriver().findElement(By.xpath("//*[@id='calcSearchOut']/div/a")).click();

        assertEquals(Driver.getDriver().getTitle(), "Gas Mileage Calculator", "nop!");
        assertEquals(Driver.getDriver().findElement(By.xpath("//*[@id='content']/h1")).isDisplayed(),true,"nop!");

        Driver.getDriver().findElement(By.id("uscodreading")).clear();
        Driver.getDriver().findElement(By.id("uscodreading")).sendKeys("7925");
        Driver.getDriver().findElement(By.id("uspodreading")).clear();
        Driver.getDriver().findElement(By.id("uspodreading")).sendKeys("7550");
        Driver.getDriver().findElement(By.id("usgasputin")).clear();
        Driver.getDriver().findElement(By.id("usgasputin")).sendKeys("16");
        Driver.getDriver().findElement(By.id("usgasprice")).clear();
        Driver.getDriver().findElement(By.id("usgasprice")).sendKeys("3.55");

        Driver.getDriver().findElement(By.xpath("//*[@id='standard']/tbody/tr[5]/td/input")).click();
        assertEquals(Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText(),"23.44 mpg","test failed!");

        Driver.closeDriver();
    }
}
