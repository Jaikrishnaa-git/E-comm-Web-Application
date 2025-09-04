package com.Ecomm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtilities {

    public static String capturescreen(WebDriver driver, String screenshotName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = "Screenshots/" + screenshotName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(destPath);

        // Ensure directory exists
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(src, dest);

        return dest.getAbsolutePath();
    }
}
