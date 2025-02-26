package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookTest {

    WebDriver driver;
    String baseUrl;

    String email = "email";
    String pwd = "pass";
    String loginButton = "login";
    String errorMessage = "error_box";

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        baseUrl = "https://www.facebook.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    void invalidUsernameTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.id(email)).sendKeys("invalid_user@gmail.com");
        driver.findElement(By.id(pwd)).sendKeys("dummyPassword");
        driver.findElement(By.name(loginButton)).click();
        Thread.sleep(3000);
        WebElement errorMessageElement = driver.findElement(By.id(errorMessage));
        Assert.assertTrue(errorMessageElement.isDisplayed(), "Link element was not found");
    }

    @AfterClass
    void tearDown() {
        System.out.println("Quitting the browser");
        driver.quit();
    }

}
