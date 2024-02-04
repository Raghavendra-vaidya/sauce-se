package com.sauce_se.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sauce.configuration.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        driver = setupDriver(browser);
    }

    @Test
    public void test1() {
        boolean isElementVisible = driver.findElement(By.id("user-name")).isDisplayed();
        Assert.assertTrue(isElementVisible);
    }

    @Test
    public void test2() {
        boolean isElementVisible = driver.findElement(By.id("password")).isDisplayed();
        Assert.assertTrue(isElementVisible);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
