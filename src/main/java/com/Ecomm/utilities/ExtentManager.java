package com.Ecomm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static String projectPath = System.getProperty("user.dir");

    public static ExtentReports createInstance(String name) {
     	name = name+".html";
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\src\\test\\resources\\Reports\\"+name);
        extent.attachReporter(spark);
        return extent;
    }

}
