package PlayAround.HollywoodBet.testing;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.TableStats;
import Utilities.ExtentReport;

public class AppTest extends Base {
	
	@BeforeMethod
	public void testSetup(Method testMethod) {
		System.out.println("Test setup");
		test= ExtentReport.createTest(testMethod.getName());
	}

	@Test(dataProvider = "getTeams")
	public void testTrial(List<Hashtable> items) {
		//System.out.println("Home:" + items.get(0).get("Home").toString());
		//System.out.println("directory"+directory);
		//System.out.println("folder"+foldername);
		driver.goToURL("https://fbref.com/en/");
		TableStats stats=new TableStats(driver,test);
		test.log(Status.PASS, "Home - "+items.get(0).get("Home").toString());
		stats.printGoalDff(items.get(0).get("Home").toString());
		test.log(Status.PASS, "Home - "+items.get(0).get("Away").toString());
		stats.printGoalDff(items.get(0).get("Away").toString());
	}

	@AfterMethod
	public void testTearDown() {
		System.out.println("Test teardown");
	}

	@DataProvider
	public Object[][] getTeams() {
		Object[][] data = new Object[1][1];
		Hashtable table = new Hashtable();
		table.put("Home", "Liverpool");
		table.put("Away", "Wolves");
		List<Hashtable> dataHolder = new ArrayList<Hashtable>();
		dataHolder.add(table);
		data[0][0] = dataHolder;
		return data;
	}

}
