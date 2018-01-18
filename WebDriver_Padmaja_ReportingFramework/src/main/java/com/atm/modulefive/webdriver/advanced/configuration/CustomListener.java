package com.atm.modulefive.webdriver.advanced.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    WebDriver driver = DefaultDriver.initializeDriver(); // [IK] I suggest not to do like this //[MK] Removed the driver setting from null to singleton
    String filePath = "./evidence/screenshots/";  
    Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult result) { 
    	
    // [IK] Make more optimal usage of strings. The example is below.
	// [MK] Implemnted the same with the example given by you
	/*
	 *  result.getName() repeats twice. Make it use once, as shown below.
	 *  
	 */
	String resultOutput = result.getName();
	logger.info("*****The name of the testcase Started is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "Startof" + methodName;
	takeScreenshot(Name);
    }

    public void onTestSuccess(ITestResult result) { // [IK] Make more optimal
						    // usage of strings. [MK] Done
    String resultOutput = result.getName();
	logger.info("*****The name of the testcase Passed is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "OnSuccessof" + methodName;
	takeScreenshot(Name);
    }

    public void onTestFailure(ITestResult result) { // [IK] Make more optimal
						    // usage of strings. [MK] Done
    String resultOutput = result.getName();
	logger.info("*****The name of the testcase Failed is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "OnFailureof" + methodName;
	takeScreenshot(Name);
    }

    /*
     * [IK] Added to check screenshots.
     * 
     */
    public void takeIntermediateScreenshot(String name) {
	logger.info("Taking screenshot of: " + name);
	takeScreenshot(name);
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

    }

    private void takeScreenshot(String Name) {
	driver = DefaultDriver.initializeDriver();
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
	    FileUtils.copyFile(scrFile, new File(filePath + Name + ".png"));
	} catch (IOException e) {
	    logger.trace("Error in plcaing the file due to, " + e.getMessage());
	}
    }

}
