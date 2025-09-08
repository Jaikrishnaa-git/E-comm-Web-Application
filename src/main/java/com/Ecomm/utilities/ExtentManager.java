package com.Ecomm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    static String projectPath = System.getProperty("user.dir");

<<<<<<< HEAD
    public static ExtentReports createInstance(String name) {
     	name = name+".html";
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\src\\test\\resources\\Reports\\"+name);
        extent.attachReporter(spark);
=======
    // Use this method to create and return ExtentReports instance
    public static ExtentReports createInstance(String testClassName) {
        if (extent == null) {
            // Set report file name dynamically based on test class name
            String reportName = testClassName + ".html";

            // Set file path for report
            ExtentSparkReporter spark = new ExtentSparkReporter(
                    projectPath + "\\src\\test\\resources\\Reports\\" + reportName
            );

            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("Execution Results - " + testClassName);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Add basic system info to the report
            extent.setSystemInfo("Project", "E-Commerce Automation");
            extent.setSystemInfo("Tester", "Vinod Reddy");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
>>>>>>> 77bb121 (2025sep8 project)
        return extent;
    }

}
