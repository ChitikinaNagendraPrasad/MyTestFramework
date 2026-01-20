package com.practice.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Pages.HomePage;
import com.practice.Pages.LoginPage;

public class TestCases extends Base
{
    HomePage homePage = null;
    LoginPage loginPage = null;

    @BeforeMethod()
    public void initPages()
    {
        try
        {
            homePage = new HomePage(driver);
            loginPage = new LoginPage(driver);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @AfterMethod
    public void closeBrowser()
    {
        try
        {
            //driver.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase_001()
    {
        String email = "nag@nag.com";
        String password = "password";
        try
        {
            driver.get(baseURL);
            homePage.click_SignUpOrLogin_Link();
            loginPage.loginForm_loginToYourAccount(email, password);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCase_002()
    {
        try
        {
            driver.get(baseURL);
            homePage.click_SignUpOrLogin_Link();
            loginPage.loginForm_NewUserSignUp();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCase_003()
    {
        String email = "nag@nag.com";
        String password = "password";
        try
        {
            driver.get(baseURL);
            homePage.click_SignUpOrLogin_Link();
            loginPage.loginForm_Login_Button_Click(); 
            loginPage.loginForm_EmailAddress_TextBox_Validate_ErrorMessage_PleaseFillOutThisField();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
