package com.sparta.swaglabstesting.webdrivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FirefoxDriverManager extends WebDriverManager{
    @Override
    public void createDriver() {
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/WebDriver.properties");
            prop.load(input);
            String firefoxPath = prop.getProperty("FirefoxDriverPath");
            if(System.getProperty("os.name").toLowerCase().contains("win")) {
                firefoxPath += ".exe";
            }
            System.setProperty("webdriver.gecko.driver", prop.getProperty(firefoxPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        webDriver = new FirefoxDriver(options);
    }
}
