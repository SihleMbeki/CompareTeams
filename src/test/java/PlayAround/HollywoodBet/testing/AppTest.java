package PlayAround.HollywoodBet.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest extends Base{
	
	@BeforeMethod
	public void testSetup() {
		System.out.println("Test setup");
	}

	@Test(priority=1)
	public void test() {
		System.out.println("Test method");
	}
	
	@AfterMethod
	public void testTearDown() {
		System.out.println("Test teardown");
	}
	
}
