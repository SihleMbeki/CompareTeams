package PlayAround.HollywoodBet.testing;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base {
	@BeforeSuite
	public void setup() {
		System.out.println("Setup");
	}
	
	@AfterSuite
	public void teardown() {
		System.out.println("Tear down");
	}
}

