package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PlayAround.HollywoodBet.testing.Base;

public class Listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			Base.test.pass("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Base.test.fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base.test.log(Status.FAIL, "Error:"+driver.error);
	    ExtentReport.closeReport();
		//driver.closeDriver();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Base.test.log(Status.PASS, "Passed");
		try {
			Base.test.pass("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReport.closeReport();
		//driver.closeDriver();	
	}

}
