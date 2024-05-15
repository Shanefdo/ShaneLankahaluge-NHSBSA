package org.nhsjobs.faramework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void quitBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}
