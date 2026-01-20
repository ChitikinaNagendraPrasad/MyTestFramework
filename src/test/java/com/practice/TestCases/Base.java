package com.practice.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
        try
        {
            switch(browser.toLowerCase())
            {
                case "chrome":
                {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "edge":
                {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();                    
                    break;
                }
                case "firefox":
                {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();               
                    break;
                }                
            }            
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        catch(Exception e)
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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}