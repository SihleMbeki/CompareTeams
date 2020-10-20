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

import Pages.League;
import Pages.TableStats;
import Pages.TeamStats;
import Utilities.ExtentReport;

public class AppTest extends Base {

	@BeforeMethod
	public void testSetup(Method testMethod) {
		System.out.println("Test setup");
		test = ExtentReport.createTest(testMethod.getName());
	}

	@Test(dataProvider = "getTeams")
	public void testTrial(List<Hashtable> items) {
		
		League league=new League(driver,test);
		driver.goToURL("https://fbref.com/en/");
		test.log(Status.PASS, "Home - "+items.get(0).get("Home").toString());
		league.selectLeague( items.get(0).get("League").toString()).printGoalDff(items.get(0).get("Home").toString());
		TeamStats teamstats=new TeamStats(driver,test);
		teamstats.loadSite();
		teamstats.extractStats(true, items.get(0).get("Home").toString()+" "+items.get(0).get("Country").toString());
		test.log(Status.PASS, "Away - "+items.get(0).get("Away").toString());
		driver.goToURL("https://fbref.com/en/");
		league.selectLeague("England: Premier League (m)").printGoalDff(items.get(0).get("Away").toString());
		teamstats.loadSite();
		teamstats.extractStats(false, items.get(0).get("Away").toString()+" "+items.get(0).get("Country").toString());
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
		table.put("Away", "Burnley");
		table.put("Country", "(ENGLAND)");
		table.put("League", "England: Premier League (m)");
		List<Hashtable> dataHolder = new ArrayList<Hashtable>();
		dataHolder.add(table);
		data[0][0] = dataHolder;
		return data;
	}

}
