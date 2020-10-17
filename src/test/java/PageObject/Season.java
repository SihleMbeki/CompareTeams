package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Season {
	
	@FindBy(css="a.button2.prev")
	public WebElement prev;

}
