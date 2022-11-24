package com.eurotech.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //add for extentReport
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {


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

    @AfterTest
    public void tearDownTest() {

        // this is when the report is actually created
        report.flush();

    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(Driver.get(), 15);

        driver.get(ConfigurationReader.get("urlToolsQA"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // if the test failes
        if (result.getStatus()==ITestResult.FAILURE){

            // Record the name of failed test
            extentLogger.fail(result.getName());
            //take the screenshot and return the location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            // Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            // capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(2000);
       // driver.close();

    }

}
