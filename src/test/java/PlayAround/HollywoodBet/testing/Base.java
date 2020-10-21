package PlayAround.HollywoodBet.testing;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExcelReader;
import Utilities.ExtentReport;
import Utilities.SeleniumDriver;

public class Base {
	public static String directory;
	public static String foldername;
	protected SeleniumDriver driver;
	public static ExtentTest test;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\java\\Data\\testdata.xlsx");

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
