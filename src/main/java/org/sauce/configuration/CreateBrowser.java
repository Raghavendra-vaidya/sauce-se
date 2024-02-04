package org.sauce.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sauce.utilities.LoadDetailsFile;

import java.time.Duration;

public class CreateBrowser {
    static WebDriver driver;
    static LoadDetailsFile prop = new LoadDetailsFile();
    static String appUrl = prop.getURL();

    static Integer implicitWaitTimeOut = Integer.parseInt(prop.getIMPLICIT_TIME());

    public static WebDriver instance(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setImplicitWaitTimeout(Duration.ofSeconds(implicitWaitTimeOut));//will change
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeOut));//will change
        }
        driver.get(appUrl);// will change
        return driver;
    }
}
