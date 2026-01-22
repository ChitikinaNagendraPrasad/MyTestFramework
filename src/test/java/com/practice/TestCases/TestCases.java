package com.practice.TestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
            // driver.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void TC001_RegisterUser()
    {
        String actualTitle = null;
        String expectedTitle = null;
        try
        {
            actualTitle = homePage.getPageTitle();
            expectedTitle = HomePage.homePageTitle+"Nag";
            if (! actualTitle.equals(expectedTitle))
            {
                System.out.println("Home Page Title Mismatched");
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            } 
            assertEquals(actualTitle, expectedTitle, "Home Page Title Mismatch");
            homePage.click_SignUpOrLogin_Link();
            actualTitle = loginPage.getPageTitle();
            expectedTitle = LoginPage.loginPageTitle;
            if (! actualTitle.equals(expectedTitle))
            {
                System.out.println("Signup/Login Page Title Mismatched");
                captureScreenshot(driver, "TC001_RegisterUser");
            }            
            assertEquals(actualTitle, expectedTitle, "Signup/Login Page Title Mismatch");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
