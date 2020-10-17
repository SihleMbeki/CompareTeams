package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeagueObject {
	
	@FindBy(xpath="//select[@class='sr_fb_fave']")
	public WebElement league;
}
