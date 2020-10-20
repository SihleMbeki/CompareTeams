package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Stats {
	@FindBy(xpath = "(//input[starts-with(@id,'autocomplete')])[1]")
	public WebElement searchInputs;

	@FindBy(xpath = "//h2[text()='First goal, leading & trailing']")
	public WebElement trailing;

	@FindBy(xpath = "//h2[text()='First goal, leading & trailing']//following::div[position()='1']//a[contains(@title,'Home')]")	
	public WebElement trailingHome;
	
	public String homeTab="//h2[text()='First goal, leading & trailing']//following::div[position()='1']//a[contains(@title,'Home')]";
	
	public String home = "//h2[text()='First goal, leading & trailing']//following::div[position()='1']//a[contains(@title,'Home')]";

	@FindBy(xpath = "//h2[text()='First goal, leading & trailing']//following::div[position()='1']//a[contains(@title,'Away')]")
	public WebElement trailingAway;
	
	public String away = "//h2[text()='First goal, leading & trailing']//following::div[position()='1']//a[contains(@title,'Away')]";

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Average minutes leading')])[2]//parent::tr//td[2]/font")
	public WebElement avgLeadingHome;

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Average minutes trailing')])[2]//parent::tr//td[2]/font")
	public WebElement avgTrailingHome;

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Team scored first')])[2]//parent::tr//td[3]")
	public WebElement avgScoredFirstHome;

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Average minutes leading')])[3]//parent::tr//td[2]/font")
	public WebElement avgLeadingAway;

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Average minutes trailing')])[3]//parent::tr//td[2]/font")
	public WebElement avgTrailingAway;

	@FindBy(xpath = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Team scored first')])[3]//parent::tr//td[3]")
	public WebElement avgScoredFirstAway;

	@FindBy(xpath = "//button[text()='AGREE']")
	public WebElement agreeButton;

	public String site() {
		return "https://www.soccerstats.com/";
	}

	public String getLeading = "(//h2[text()='First goal, leading & trailing']//following::div[position()='1']//td[contains(text(),'Average minutes leading')])[2]//parent::tr//td[2]/font";

	public String agreeButton() {
		return "//button[text()='AGREE']";
	}

}
