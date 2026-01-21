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
        String actualTitle = homePage.getPageTitle();
        String expectedTitle = HomePage.homePageTitle;
        try
        {
            actualTitle = homePage.getPageTitle();
            expectedTitle = HomePage.homePageTitle;
            if (! actualTitle.equals(expectedTitle))
            {
                System.out.println("Home Page Title Mismatched");
                captureScreenshot(driver, "TC001_RegisterUser");
            } 
            assertEquals(actualTitle, expectedTitle, "Home Page Title Mismatch");
            homePage.click_SignUpOrLogin_Link();
            actualTitle = loginPage.getPageTitle();
            expectedTitle = LoginPage.loginPageTitle+"abcd";
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

    /*
     * @Test public void testCase_001() { String email = "nag@nag.com"; String
     * password = "password"; try { driver.get(baseURL);
     * homePage.click_SignUpOrLogin_Link();
     * loginPage.loginForm_loginToYourAccount(email, password);
     * 
     * } catch (Exception e) { e.printStackTrace(); } }
     * 
     * @Test public void testCase_002() { try { driver.get(baseURL);
     * homePage.click_SignUpOrLogin_Link(); loginPage.loginForm_NewUserSignUp();
     * 
     * } catch (Exception e) { e.printStackTrace(); } }
     * 
     * @Test public void testCase_003() { //String email = "nag@nag.com";
     * //String password = "password"; try { driver.get(baseURL);
     * homePage.click_SignUpOrLogin_Link();
     * loginPage.loginForm_Login_Button_Click(); loginPage.
     * loginForm_EmailAddress_TextBox_Validate_ErrorMessage_PleaseFillOutThisField
     * (); } catch (Exception e) { e.printStackTrace(); } }
     */
}
