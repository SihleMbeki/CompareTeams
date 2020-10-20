package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObject.Stats;
import Utilities.SeleniumDriver;

public class TeamStats {
	SeleniumDriver driver;
	ExtentTest test;
	Stats statistics;

	public TeamStats(SeleniumDriver driver, ExtentTest test) {
		statistics = new Stats();
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(this.driver.getDriver(), statistics);
	}

	public void loadSite() {
		driver.goToURL(statistics.site());
		test.log(Status.PASS, statistics.site());
	}

	public void extractStats(boolean game, String team) {

		if (driver.waitForEelementByXpath(statistics.agreeButton())) {
			statistics.agreeButton.click();
		}

		statistics.searchInputs.click();
		statistics.searchInputs.sendKeys(team);

		for (int s = 0; s <= 5; s++) {
			if (driver.waitForEelementToBeClickableByXpath(statistics.home)) {
				break;
			} else {
				if (s > 4)
					Assert.fail("Failed to wait for trail table");
			}

		}

		if (!driver.scrollToElement(statistics.trailingHome)) {
			Assert.assertTrue(driver.scrollToElement(statistics.trailingHome));
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		statistics.searchInputs.sendKeys(Keys.PAGE_UP);// what is this?

		for (int i = 0; i <= 5; i++) {
			if (driver.waitForEelementToBeClickableByXpath(statistics.homeTab)) {
				break;
			}
		}

		if (game) {
			statistics.trailingHome.click();
		} else {
			statistics.trailingAway.click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (game) {
			test.log(Status.PASS, "Average minutes leading - " + statistics.avgLeadingHome.getText());
			test.log(Status.PASS, "Average minutes trailing - " + statistics.avgTrailingHome.getText());
			test.log(Status.PASS, "Team scored first - " + statistics.avgScoredFirstHome.getText());
		} else {
			test.log(Status.PASS, "Average minutes leading - " + statistics.avgLeadingAway.getText());
			test.log(Status.PASS, "Average minutes trailing - " + statistics.avgTrailingAway.getText());
			test.log(Status.PASS, "Team scored first - " + statistics.avgScoredFirstAway.getText());
		}
	}

}
