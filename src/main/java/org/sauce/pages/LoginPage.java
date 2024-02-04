package org.sauce.pages;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sauce.utilities.JsonUtils;
import org.sauce.utilities.LoadDetailsFile;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    WebDriverWait wait;
    LoadDetailsFile detailsFile = new LoadDetailsFile();

    Integer EXPLICIT_WAIT = Integer.parseInt(detailsFile.getEXPLICIT_TIME());
    JsonObject loginIdentifiers = JsonUtils.getFileAsObject("src/main/resources/Identifiers/loginPage.json");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(loginIdentifiers.get("pageCSS").toString())));
    }

    public WebElement getUserNameField() {

        return driver.findElement(By.id(loginIdentifiers.get("usernameID").getAsString()));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id(loginIdentifiers.get("passwordID").getAsString()));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id(loginIdentifiers.get("loginButtonID").getAsString()));
    }

    public void setUserName(String userName) {
        getUserNameField().sendKeys(userName);
    }

    public void setPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickOnLoginBtn() {
        getLoginButton().click();
    }

}
