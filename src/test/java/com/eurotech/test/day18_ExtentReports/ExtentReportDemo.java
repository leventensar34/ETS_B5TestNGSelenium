package com.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExtentReportDemo {

    // this class is used for starting and building reports
    ExtentReports report;

    //this is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test , enable adding logs , authors and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup() {

        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attacch the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("EuroTech Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Ensar");


    }

    @Test
    public void test1() {

        //give a name to the current test
        extentLogger = report.createTest("TC01 Login Test");

        //Test steps
        extentLogger.info("Open  the Browser");
        extentLogger.info("go to url http://eurotech.study/login");
        extentLogger.info("Login as Teacher");
        extentLogger.info("Enter teacher username");
        extentLogger.info("Enter teacher password");
        extentLogger.info("Click login button");
        extentLogger.info("Verify logged in");
        extentLogger.info("TC01 Login Test is passed");


    }

    @AfterMethod
    public void tearDown() {

        // this is when the report is actually created
        report.flush();

    }
}
