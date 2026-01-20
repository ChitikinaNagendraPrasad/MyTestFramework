package com.practice.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.util.ExceptionUtils;

public class MyTestListener implements ITestListener
{
    
    ExtentReports extentReports ;
    ExtentSparkReporter extentSparkReporter ;
    ExtentTest extentTest;
    
    public void configureReports()
    {
        
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        
        String extentReportPath=null;
        try
        {  
            extentReportPath=System.getProperty("user.dir")+"\\Reports\\MyReport-"+ts+".html";
            extentReports = new ExtentReports();
            extentSparkReporter = new ExtentSparkReporter(extentReportPath);
            extentReports.attachReporter(extentSparkReporter);
            
            extentReports.setSystemInfo("Machine : ", "My Machine");
            extentReports.setSystemInfo("OS : ", "Windows 11");
            extentReports.setSystemInfo("Browser : ", "Chrome");
            
            extentSparkReporter.config().setDocumentTitle("My Test Report");
            extentSparkReporter.config().setReportName("This Is My First Report");
            extentSparkReporter.config().setTheme(Theme.DARK);                      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void flushReports()
    {
        try
        {
            extentReports.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        // TODO Auto-generated method stub
       // ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestSuccess(result);
        System.out.println(result.getName()+" ==> Passed");
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel("This Test Case Passed", ExtentColor.GREEN));
       
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestFailure(result);
        System.out.println(result.getName()+" ==> Failed");
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("This Test Case Failed", ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestSkipped(result);
        System.out.println(result.getMethod()+" ==> Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context)
    {
        // TODO Auto-generated method stub
        //ITestListener.super.onStart(context);        
        System.out.println("On Start Activated");
        configureReports();
    }

    @Override
    public void onFinish(ITestContext context)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onFinish(context);
        System.out.println("On Finish Activated");
        flushReports();
    }

}
