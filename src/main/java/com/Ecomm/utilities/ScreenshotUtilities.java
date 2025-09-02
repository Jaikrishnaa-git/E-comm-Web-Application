package com.Ecomm.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtilities {
	static String projectpath=System.getProperty("user.dir")  ;
	public static String capturescreen(WebDriver driver, String TestName) throws IOException
	{
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String screenpath=projectpath+"\\src\\test\\resources\\screenshots\\TC_026.png";
	      File dest=new File(screenpath);
		  FileUtils.copyFile(src, dest);
		  return screenpath;
	}
 
}