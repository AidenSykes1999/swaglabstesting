package com.sparta.swaglabstesting.webdrivers;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EdgeDriverManager extends WebDriverManager{
    @Override
    public void createDriver() {
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/WebDriver.properties");
            prop.load(input);
            System.setProperty("webdriver.edge.driver", prop.getProperty("webDriverPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        EdgeOptions options = new EdgeOptions();
        options.setHeadless(true);
        webDriver = new EdgeDriver(options);
    }
}