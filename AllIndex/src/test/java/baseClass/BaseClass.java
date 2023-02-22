package baseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import driverManager.DriverManager;

public class BaseClass {
	
	public void robotZoomout() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void takeScreenshot(String filename,boolean ref) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) DriverManager.getInstance().getDriver();
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		if(ref) {
		FileUtils.copyFile(screenshotAs, new File(System.getProperty("user.dir")+File.separator+"test-output/Screenshots/"+filename+".png"));
		}else {
			FileUtils.copyFile(screenshotAs, new File(System.getProperty("user.dir")+File.separator+"test-output/Screenshots/Failed/"+filename+".png"));
		}
	}
	public void clickusingJavascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	public void callRobot() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getDriver();
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", ele);
	}
	public void switchToActiveElement(String value) {
		DriverManager.getInstance().getDriver().switchTo().activeElement().sendKeys(value);;
	}
}
