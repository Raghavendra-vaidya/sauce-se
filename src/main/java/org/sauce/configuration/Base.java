package org.sauce.configuration;

import org.openqa.selenium.WebDriver;

public class Base {
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    public WebDriver setupDriver(String browserName){
        threadLocal.set(CreateBrowser.instance(browserName));
        return threadLocal.get();
    }
}
