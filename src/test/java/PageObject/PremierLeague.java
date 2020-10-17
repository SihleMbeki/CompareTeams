package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * Extract team position 
 * 
 */
public class PremierLeague {
	
	@FindBy(xpath="(//div[starts-with(@id,'all_results')])[1]")
	public WebElement table;
	
	public String findRank(String team) {
		return "//a[text()='"+team+"']//ancestor::tr/th";
	}
	
	public String glDeff(String team) {
		return "//a[text()='"+team+"']//ancestor::tr//td[@data-stat='goal_diff']";
	}
	
	
	
}
