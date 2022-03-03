package com.sparta.swaglabstesting.webdrivers;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OperaDriverManager extends WebDriverManager{
    @Override
    public void createDriver() {
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/WebDriver.properties");
            prop.load(input);
            System.setProperty("webdriver.opera.driver", prop.getProperty("OperaDriverPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        OperaOptions options = new OperaOptions();
        options.addArguments("headless");
        webDriver = new OperaDriver(options);
    }
}
