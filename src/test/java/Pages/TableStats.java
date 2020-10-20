package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObject.PremierLeague;
import Utilities.SeleniumDriver;

public class TableStats {
	
	PremierLeague leagueTable;
	SeleniumDriver driver;
	ExtentTest test;
	
	public TableStats(SeleniumDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
		this.leagueTable=new PremierLeague();
		//AjaxElementLocatorFactory facctory= new AjaxElementLocatorFactory(driver.getDriver(), 0);
		PageFactory.initElements(driver.getDriver(), leagueTable);
	}

	public void printGoalDff(String team) {
		driver.scrollToElement(leagueTable.table);
		String goalDff="GoalDff:"+leagueTable.table.findElement(By.xpath(leagueTable.glDeff(team))).getText();
		String Rank="Rank:"+leagueTable.table.findElement(By.xpath(leagueTable.findRank(team))).getText();
		//System.out.println("GoalDff:"+leagueTable.table.findElement(By.xpath(leagueTable.glDeff(team))).getText());
		//System.out.println("Rank:"+leagueTable.table.findElement(By.xpath(leagueTable.glDeff(team))).getText());
		test.log(Status.PASS, goalDff);
		test.log(Status.PASS, Rank);
		
	}
}
