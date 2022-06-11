package com.cydeo.selenium.day09_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IframePractice extends TestBase {

      @Test
      public void iframeTest() throws InterruptedException {
//          2- Go to: https://practice.cydeo.com/iframe
          driver.get("https://practice.cydeo.com/iframe");

          // NOSuchElement exception comes with reasons:
          // 1- Element location not correct
          // 2- There is an iframe, and you have switch to frame to reach this element


//          3- Clear text from comment body

          // we can use frame(id) method with id arg.
          //driver.switchTo().frame("mce_0_ifr");

          // we can use frame(locator)
          // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

          // we can find iframe tags from html with using xpath "//iframe"

          // we can use frame(index) : index starts from 0
          driver.switchTo().frame(0);




          /**
           * WebElement iframe = driver.findElement(By.tagName("iframe"));
           * driver.switchTo().frame(iframe);       -> by locator
           *
           * driver.switchTo().frame(0);            -> by index
           *
           * driver.switchTo().frame("iframe-id");  -> by id Name
           *
           * driver.switchTo().parentFrame();        -> switch back to parentFrame
           * driver.switchTo().defaultContent();     -> switch back to default HTML
           */


          WebElement commentBody = driver.findElement(By.id("tinymce"));
          // clear() method delete text form comment body.
          commentBody.clear();


//          4- Type "Hello World" in comment body
          commentBody.sendKeys("Hello World");

//          5- Verify "Hello World" text is written in comment body
         assertEquals(commentBody.getText(),"Hello World");

         // if you have nested frame and if you want to switch 1 frame to direct parent of this frame we are using parentFrame() method
         driver.switchTo().parentFrame();

         // defaultContent() method will switch to main HTML (Parent of all HTML)
         // driver.switchTo().defaultContent();

//          6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
          WebElement headerText = driver.findElement(By.tagName("h3"));
         assertTrue(headerText.isDisplayed(),"Header text did not appear!");

         String actualHeader = headerText.getText();
         String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";

         assertEquals(actualHeader,expectedHeader,"Header text did not appear correctly!");


      }
}
