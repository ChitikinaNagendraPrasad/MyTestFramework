package com.practice.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Utilities
{
    public static void fluent_Click(WebDriver driver, WebElement element)
    {
        try
        {
            WebElement ele = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(ElementClickInterceptedException.class)
            .until(ExpectedConditions.elementToBeClickable(element));
            ele.click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void fluent_Fill(WebDriver driver, WebElement element, String data)
    {
        try
        {
            WebElement ele = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(ElementClickInterceptedException.class)
            .until(ExpectedConditions.elementToBeClickable(element));
            ele.sendKeys(data);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
