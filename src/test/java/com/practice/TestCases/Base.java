package com.practice.TestCases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.practice.Utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{
    public ConfigReader configReader = new ConfigReader();
    public String browser = configReader.getBrowser();
    public String baseURL = configReader.getBaseURL();
    public WebDriver driver = null;
 
    @BeforeClass
    public void setUP()
    {
        System.out.println("Browser = " + browser);
        try
        {
            switch (browser.toLowerCase())
            {
                case "chrome": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
                }
                case "edge": {
                    EdgeOptions options = new EdgeOptions();
                    //options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(options);
                    break;
                }
                case "firefox": {
                    FirefoxOptions options = new FirefoxOptions();
                    //options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(options);
                    break;
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(baseURL);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown()
    {
        try
        {
            driver.quit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void captureScreenshot(WebDriver tdriver, String testCaseName)
    {
        try
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}