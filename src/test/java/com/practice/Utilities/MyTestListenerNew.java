package com.practice.Utilities;

import java.awt.Color;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyTestListenerNew implements ITestListener
{

    String fileTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\TestReport-" + fileTimestamp + ".html");
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result)
    {

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel("This Test Case Passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        try
        {
            System.out.println(result.getName() + " ==> Failed");

            extentTest = extentReports.createTest(result.getName());
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("This Test Case Failed", ExtentColor.RED));

            String projectDir = System.getProperty("user.dir");

            // ✅ Absolute path only to verify file exists
            String screenshotAbsolutePath = projectDir + "/Screenshots/" + result.getName() + ".png";

            // ✅ Relative path for Extent HTML rendering
            String screenshotRelativePath = "../Screenshots/" + result.getName() + ".png";

            File screenshotFile = new File(screenshotAbsolutePath);

            if (screenshotFile.exists() && screenshotFile.length() > 0)
            {
                extentTest.fail("Captured Screenshot Is Below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotRelativePath).build());
                Throwable throwable = result.getThrowable();
                if (throwable != null)
                {
                    extentTest.fail("Exception: " + throwable.getMessage());
                    //extentTest.fail("<pre>" + getStackTrace(throwable) + "</pre>");
                }

            } else
            {
                extentTest.warning("Screenshot not found at: " + screenshotAbsolutePath);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onStart(context);
        System.out.println("onStart Method From \"MyTestListner.java\" Started");
        System.out.println("File Time Stamp : " + fileTimestamp);
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Machine : ", "My Machine");
        extentReports.setSystemInfo("OS : ", "Windows 11");
        extentReports.setSystemInfo("Browser : ", "Chrome");

        extentSparkReporter.config().setDocumentTitle("My Test Report");
        extentSparkReporter.config().setReportName("This Is My First Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        // TODO Auto-generated method stub
        ITestListener.super.onFinish(context);
        System.out.println("onFinish Method From \"MyTestListner.java\" Started");
        extentReports.flush();
    }

    private String getStackTrace(Throwable t)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

}
