package Pages;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObject.LeagueObject;
import PageObject.PremierLeague;
import Utilities.SeleniumDriver;

public class League {
	SeleniumDriver driver;
	ExtentTest test;
	LeagueObject league;
	
	public League(SeleniumDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
		this.league=new LeagueObject();
		//AjaxElementLocatorFactory facctory= new AjaxElementLocatorFactory(driver.getDriver(), 0);
		PageFactory.initElements(driver.getDriver(), league);
	}
	
	public TableStats selectLeague(String league) {
		driver.selectDropDown(this.league.league, league);
		test.log(Status.PASS, league);
		return new TableStats(driver,test);
	}

}
