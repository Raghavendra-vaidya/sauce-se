package org.sauce.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class CreateBrowser {
    static WebDriver driver;

    public static WebDriver instance(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setImplicitWaitTimeout(Duration.ofSeconds(2));//will change
            driver =new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//will change
        }
        driver.get("https://www.saucedemo.com/v1/");// will change
        return driver;
    }
}
