package com.sauce_se.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sauce.configuration.Base;
import org.sauce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        driver = setupDriver(browser);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void test2() {
        //loginPage.waitForPageToLoad();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
    }

    @Test
    public void test1() {
        Assert.assertTrue(loginPage.getUserNameField().isEnabled());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
