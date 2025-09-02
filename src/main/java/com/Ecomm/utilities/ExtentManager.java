package com.Ecomm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	static String projectPath = System.getProperty("user.dir");
	public static ExtentReports getInstance()
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(projectPath+"\\src\\test\\resources\\Reports\\ReportAug29.html");
		extent.attachReporter(spark);
		return extent;
	}
}
