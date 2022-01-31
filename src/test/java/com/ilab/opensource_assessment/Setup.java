package com.ilab.opensource_assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Setup {
	public static WebDriver driver = null;
	public ExtentReports extent = null;
	ExtentTest test = null;

	public static Logger log = null;

	@BeforeSuite
	public void config() {
		//log4j
		log = LogManager.getLogger(Setup.class.getName());
		//ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Lebo");
	}

	@BeforeTest
	public void setup() {
		ExtentTest test = extent.createTest("Open orangeHRM url", "");

		try {
			FileInputStream fis = new FileInputStream("./config.properties");
			Properties config = new Properties();

			config.load(fis);


			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(config.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			//taking a screenshot
			//test.addScreenCaptureFromBase64String("");

			//validate page title
			if(!driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
				test.fail("");
				log.error("Invalid Page Title.");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void EvaluateResult(ITestResult Results) {
		if(Results.getStatus() == ITestResult.FAILURE) {
			test.fail("Test Fail");
			log.info("Test Failed");
		}else {
			test.pass("Test has passed");
			log.info("Test has Passed");
		}
	}

	@AfterTest
	public void Extentflush() {
		extent.flush();
	}

}
