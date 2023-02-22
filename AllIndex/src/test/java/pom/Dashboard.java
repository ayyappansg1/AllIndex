package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import driverManager.DriverManager;

public class Dashboard extends BaseClass{
	private static Dashboard instance;
	public static Dashboard getInstance() {
		if(instance==null) {
			instance=new Dashboard();
		}
		return instance;
	}
	private Dashboard() {
		PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
	}
	@FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root Mui')])[1]")
	private WebElement loginButtonInDashboard;
	@FindBy(xpath = "//div[contains(@class,'MuiButtonBase')]//span[text()='compare']")
	private WebElement compareMenu;
	@FindBy(xpath = "//button[@id='rcc-confirm-button']")
	private WebElement cookiesAccept;
	
	public void acceptCookies() {
		try {
		cookiesAccept.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebElement getLoginButtonInDashboard() {
		return loginButtonInDashboard;
	}
	public void clickLoginInButton() {
		highlight(loginButtonInDashboard);
		loginButtonInDashboard.click();
	}
	public void clickCompareMenu() {
		highlight(compareMenu);
		compareMenu.click();
	}
	
	
	
}
