package com.sparta.swaglabstesting.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChromeDriverManager extends WebDriverManager{
    @Override
    public void createDriver() {

        try {

            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("src/test/resources/WebDriver.properties");
            prop.load(input);
            String chromePath = prop.getProperty("ChromeDriverPath");

            if(System.getProperty("os.name").toLowerCase().contains("win")) {
                chromePath += ".exe";
            }

            System.setProperty("webdriver.chrome.driver", chromePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

    }
}
