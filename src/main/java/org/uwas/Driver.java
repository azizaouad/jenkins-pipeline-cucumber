package org.uwas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver webDriver;
    private String baseUrl;

    final Logger logger = LoggerFactory.getLogger(Driver.class);

    public  Driver(WebDriver webDriver, String baseUrl) {

        this.webDriver=webDriver;
        this.baseUrl=baseUrl;

    }
    public  Driver() {
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    public void setupController() {
        String driverType = "";
        if ( System.getProperty("webDriver") != "" ) {
            driverType=System.getProperty("webDriver");
        }

        else {
            logger.error("webDriver not provided");
        }

        if (driverType.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            this.webDriver = new FirefoxDriver(options);
            this.webDriver.manage().window().maximize();
            this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else {
            if (driverType.equals("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                this.webDriver = new ChromeDriver(options);
                this.webDriver.manage().window().maximize();
                this.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            }
            else {
                logger.error("driver type is not chrome or firefox");
            }
        }


        if (System.getProperty("environment").equals("recette")){
            baseUrl= "https://coralio:cmVjZXR0ZWNvcmFsaW8yMDIyCg==@"+System.getProperty("environment")+".uwas.fr";
        }
        else {
            baseUrl= "https://"+System.getProperty("environment")+".uwas.fr";

        }
        logger.info("BaseUrl to test is :"+baseUrl);

    }

    public void teardownController() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}