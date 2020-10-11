package PlayAround.HollywoodBet.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Utilities.ExtentReport;

public class Base {
	public static String directory;

	public Base() {
		
	}

	@BeforeSuite
	public void setup() {
		directory = System.getProperty("user.dir");	
		ExtentReport.createExtentReports();
		System.out.println("Setup");
	}

	@AfterSuite
	public void teardown() {
		ExtentReport.closeReport();
		System.out.println("Tear down");
	}
}
