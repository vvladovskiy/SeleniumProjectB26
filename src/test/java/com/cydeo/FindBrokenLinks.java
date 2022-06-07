package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * How to identify broken links in Selenium WebDriver
 * -Collect all the links present on a web page based on the <a> tag.
 * -Send HTTP request for each link.
 * -Verify the HTTP response code.
 * -Determine if the link is valid or broken based on the HTTP response code.
 * -Repeat the process for all links captured with the first step.
 */

public class FindBrokenLinks {
    public static void main(String[] args) {
        String hrefValues = "";
        HttpURLConnection connection = null;
        int statusCode = 200;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/status_codes");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            hrefValues = links.get(i).getAttribute("href");
            System.out.println(hrefValues);
            if (hrefValues == null || hrefValues.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                connection = (HttpURLConnection) (new URL(hrefValues).openConnection());

                connection.setRequestMethod("HEAD");

                connection.connect();

                statusCode = connection.getResponseCode();

                if (statusCode == 200) {
                    System.out.println(hrefValues + " is a valid link");

                } else {
                    System.out.println(hrefValues + " is a broken link");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
