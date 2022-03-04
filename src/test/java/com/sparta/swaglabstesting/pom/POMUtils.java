package com.sparta.swaglabstesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class POMUtils {

    public static void setDriverLocation(String pathToDriver) {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }

    public static void setDriverLocation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    }

    public static WebDriver setUpWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

}
