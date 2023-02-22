package hooks;

import java.io.IOException;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Utilities;

public class Hooks {
	
	@Before
	public void before() throws IOException
	{
		DriverManager.getInstance().launchBrowser();
	}
	@After
	public void after() throws IOException
	{
		//DriverManager.getInstance().getDriver().close();
		System.out.println("Checking Git Flow");
	}
}
