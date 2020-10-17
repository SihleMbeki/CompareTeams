package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObject.PremierLeague;
import Utilities.SeleniumDriver;

public class TableStats {
	
	PremierLeague leagueTable;
	SeleniumDriver driver;
	
	public TableStats(SeleniumDriver driver) {
		this.driver=driver;
		this.leagueTable=new PremierLeague();
		PageFactory.initElements(driver.getDriver(), leagueTable);
	}

	public void printGoalDff() {
		driver.scrollToElement(leagueTable.table);
		System.out.println("GoalDff:"+leagueTable.table.findElement(By.xpath(leagueTable.glDeff("Wolves"))).getText());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
