package driverManager;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Utilities;

public class DriverManager {
	WebDriver driver;
	private DriverManager() {
	}
	private static DriverManager instance;
	public static DriverManager getInstance() {
		if(instance==null) {
			instance=new DriverManager();
		}
		return instance;
	}
	public void launchBrowser() throws IOException {
		switch (Utilities.getInstance().readPropertyFile("browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayyappan.g\\eclipse-workspace\\AllIndex\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ayyappan.g\\eclipse-workspace\\AllIndex\\src\\test\\resources\\Driver\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayyappan.g\\eclipse-workspace\\AllIndex\\src\\test\\resources\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			break;
		default:
			break;
		}
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	

}
