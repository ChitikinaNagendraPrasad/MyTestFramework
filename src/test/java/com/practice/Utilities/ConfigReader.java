package com.practice.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader
{
    Properties pro = new Properties();
    public ConfigReader()
    {
        try
        {
            String configFilePath=System.getProperty("user.dir")+"\\Config\\config.properties";
            FileInputStream fis = new FileInputStream(configFilePath);
            pro.load(fis);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }             
    }
    
    public String getBrowser()
    {
        String returnValue=null;
        try
        {
            returnValue=pro.getProperty("browser");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String getBaseURL()
    {
        String returnValue=null;
        try
        {
            returnValue=pro.getProperty("baseURL");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String getConfigProperty(String configFileKey)
    {
        String returnValue=null;
        try
        {
            returnValue=pro.getProperty(configFileKey);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
}
