package com.practice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.practice.Utilities.Utilities;

public class LoginPage
{
    WebDriver ldriver=null;
    public LoginPage(WebDriver rdriver)
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
    
    public static String loginPageTitle="Automation Exercise - Signup / Login";
    
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
    
    @FindBy(xpath="//div[@class=\"login-form\"]")
    WebElement loginForm;
    
    @FindBy(xpath="//input[@data-qa=\"login-email\"]")
    WebElement loginForm_EmailAddress_TextBox;
    
    public void loginForm_EmailAddress_TextBox_Fill(String email)
    {
        try
        {
            //String validationMessage = loginForm_EmailAddress_TextBox.getAttribute("validationMessage");
            Utilities.fluent_Fill(ldriver, loginForm_EmailAddress_TextBox, email);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void loginForm_EmailAddress_TextBox_Validate_ErrorMessage_PleaseFillOutThisField()
    {
        try
        {
            String expectedMessage = "Please fill out this field.";
            String actualMessage = loginForm_EmailAddress_TextBox.getAttribute("validationMessage");
            Assert.assertEquals(actualMessage, expectedMessage,"Expected And Actual Error Message Not Matched");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    @FindBy(xpath="//input[@placeholder=\"Password\"]")
    WebElement loginForm_Password_TextBox;
    
    public void loginForm_Password_TextBox_Fill(String password)
    {
        try
        {
            //String validationMessage = loginForm_Password_TextBox.getAttribute("validationMessage");
            Utilities.fluent_Fill(ldriver, loginForm_Password_TextBox, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
      
    @FindBy(xpath="//button[normalize-space()=\"Login\"]")
    WebElement loginForm_Login_Button;
    
    public void loginForm_Login_Button_Click()
    {
        try
        {
            Utilities.fluent_Click(ldriver,loginForm_Login_Button);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    public void loginForm_loginToYourAccount(String email, String password)
    {
        try
        {            
            Utilities.fluent_Fill(ldriver, loginForm_EmailAddress_TextBox, email);            
            Utilities.fluent_Fill(ldriver, loginForm_Password_TextBox, password);
            Utilities.fluent_Click(ldriver, loginForm_Login_Button);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
       
    @FindBy(xpath="//div[@class=\"signup-form\"]")
    WebElement signupForm;

    @FindBy(xpath="//input[@placeholder=\"Name\"]")
    WebElement signupForm_Name_TextBox;
    
    @FindBy(xpath="//input[@data-qa=\"signup-email\"]")
    WebElement signupForm_EmailAddress_TextBox;
    
    @FindBy(xpath="//button[normalize-space()=\"Signup\"]")
    WebElement signupForm_Signup_Button;
    
    
    public void loginForm_NewUserSignUp()
    {
        try
        {            
            Utilities.fluent_Fill(ldriver, signupForm_Name_TextBox, "Nagendra");            
            Utilities.fluent_Fill(ldriver, signupForm_EmailAddress_TextBox, "nag@nag.com");
            Utilities.fluent_Click(ldriver, signupForm_Signup_Button);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
