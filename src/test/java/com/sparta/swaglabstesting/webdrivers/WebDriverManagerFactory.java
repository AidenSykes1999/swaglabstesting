package com.sparta.swaglabstesting.webdrivers;

public class WebDriverManagerFactory {
    // Return a new instance of WebDriverManager, based on the parameter
    public static WebDriverManager getDriverManager(WebDriverType webDriverType){
        WebDriverManager webDriverManager;

        switch (webDriverType) {
            case FIREFOX -> {
                webDriverManager = new FirefoxDriverManager();
                break;
            }
            case OPERA -> {
                webDriverManager = new OperaDriverManager();
                break;
            }
            case EDGE -> {
                webDriverManager = new EdgeDriverManager();
                break;
            }
            case CHROME -> {
                webDriverManager = new ChromeDriverManager();
                break;
            }
            default -> {
                webDriverManager = null;
                break;
            }
        }
        return webDriverManager;
    }
}
