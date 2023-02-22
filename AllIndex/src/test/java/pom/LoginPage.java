package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import driverManager.DriverManager;

public class LoginPage extends BaseClass {
	private static LoginPage instance;
	public static LoginPage getInstance() {
		if(instance==null) {
			instance=new LoginPage();
		}
		return instance;
	}
	private LoginPage() {
		PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
	}
	@FindBy(xpath = "//input[@id=':r5:']")
	private WebElement usernameBox;
	@FindBy(xpath = "//input[@id=':r6:']")
	private WebElement passwordBox;
	
	public WebElement getUsernameBox() {
		return usernameBox;
	}
	public WebElement getPasswordBox() {
		return passwordBox;
	}
	
	public void enterUsername(String username) {
		highlight(usernameBox);
		usernameBox.sendKeys(username);
	}
	public void enterPassword(String password) {
		highlight(passwordBox);
		passwordBox.sendKeys(password+Keys.ENTER);
	}

}
