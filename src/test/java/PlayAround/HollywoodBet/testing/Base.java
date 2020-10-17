package PlayAround.HollywoodBet.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReport;
import Utilities.SeleniumDriver;

public class Base {
	public static String directory;
	public static String foldername;
	protected SeleniumDriver driver;
	public static ExtentTest test;

	public Base() {
		
	}

	@BeforeSuite
	public void setup() {
		directory = System.getProperty("user.dir");	
		ExtentReport.createExtentReports();
		driver= new SeleniumDriver();
		System.out.println("Setup");
	}

	@AfterSuite
	public void teardown() {
		ExtentReport.closeReport();
		driver.closeDriver();
		System.out.println("Tear down");
		
	}
}
