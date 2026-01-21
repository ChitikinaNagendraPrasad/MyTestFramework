package com.practice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.Utilities.Utilities;

public class HomePage
{
    WebDriver ldriver;
    
    public HomePage(WebDriver rdriver)
    {
        try
        {
            ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static String homePageTitle="Automation Exercise";
    
    public String getPageTitle()
    {
        String returnValue=null;
        try
        {
            returnValue=ldriver.getTitle();                   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    @FindBy(xpath="//img[@alt=\"Website for automation practice\"]")
    WebElement automationExercise_Image;
        
    @FindBy(xpath="//a[normalize-space()=\"Home\"]") 
    WebElement homePage_Link;
    
    @FindBy(xpath="//a[@href=\"/products\"]")
    WebElement product_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"Cart\"]")
    WebElement cart_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"Signup / Login\"]")
    WebElement signupOrLogin_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"Test Cases\"]")
    WebElement testCases_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"API Testing\"]")
    WebElement apiTesting_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"Video Tutorials\"]")
    WebElement videoTutorials_Page_Link;
    
    @FindBy(xpath="//a[normalize-space()=\"Contact us\"]")
    WebElement contactUs_Page_Link;
    
    public void click_SignUpOrLogin_Link()
    {
        try
        {   
            Utilities.fluent_Click(ldriver, signupOrLogin_Page_Link);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    

}
