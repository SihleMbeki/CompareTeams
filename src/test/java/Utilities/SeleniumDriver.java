package Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PlayAround.HollywoodBet.testing.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	WebDriver driver;
	String error = null;

	public SeleniumDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public boolean goToURL(String url) {
		try {
			driver.get(url);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean switchFrrame(String id) {
		try {
			driver.switchTo().frame(id);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean switchToDefault() {
		try {
			driver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean waitForElement(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean clickElementJavaScript(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean robotKeyPressEnter(WebElement element) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean takeScreenshot(WebElement element) {
		try {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(Base.foldername + "\\" + fileName));
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean selectDropDown(WebElement select, String option) {
		try {
			Select selection = new Select(select);
			selection.selectByVisibleText(option);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean scrollToElement(String xpath) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'Center'});", xpath);
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean actionClick(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public boolean acceptAlert(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public String getAlertText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			return alert.getText();
		} catch (Exception e) {
			error = e.getMessage();
			return null;
		}
	}

	public boolean nextTab() {
		Set windows = driver.getWindowHandles();
		Iterator iterate = windows.iterator();
		try {
			driver.switchTo().window(iterate.next().toString());
			return true;
		} catch (Exception e) {
			error = e.getMessage();
			return false;
		}
	}

	public String extractValue(WebElement element, String name) {
		return element.getAttribute(name);
	}

	public String extractText(WebElement element, String name) {
		return element.getText();
	}

	public String getError() {
		return error;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeDriver() {
		if (driver != null) {
			driver.close();
		}
	}

}
