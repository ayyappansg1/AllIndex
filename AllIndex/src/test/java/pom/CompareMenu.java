package pom;

import java.awt.AWTException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import driverManager.DriverManager;

public class CompareMenu extends BaseClass{
	private static CompareMenu instance;
	public static CompareMenu getInstance() {
		if(instance==null) {
			instance=new CompareMenu();
		}
		return instance;
	}
	private CompareMenu() {
		PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
	}
	@FindBy(xpath = "//input[@id=':ra:']")
	private WebElement searchBox;
	@FindBy(xpath = "//button[@id=':rc:']")
	private WebElement verifyButton;

	@FindBy(xpath = "//h5[text()='Performance Chart']")
	private WebElement performanceExpand;
	@FindBy(xpath = "(//*[local-name()='svg' and contains(@style,'100%')])[1]//*[name()='g' and @aria-label='Legend']//*[name()='text']")
	private List<WebElement> chartLabels;
	@FindBy(xpath = "//h5[text()='Statistics']")
	private WebElement statisticsExpand;
	@FindBy(xpath = "(//table[@class='table  m-0'])[1]//th")
	private List<WebElement> statisticsTableHeaders;

	@FindBy(xpath = "//h5[text()='Parameters']")
	private WebElement parameterExpand;
	@FindBy(xpath = "(//table[@class='table  m-0'])[2]//th")
	private List<WebElement> parameterTableHeaders;

	@FindBy(xpath = "//h5[text()='ESG']")
	private WebElement esgExpand;
	@FindBy(xpath = "(//table[@class='table  m-0'])[3]//th")
	private List<WebElement> esgTableHeaders;

	@FindBy(xpath = "//h5[text()='Universe']")
	private WebElement UniverseExpand;
	@FindBy(xpath = "(//table[@class='table  m-0'])[4]//th")
	private List<WebElement> UniverseTableHeaders;

	@FindBy(xpath = "(//table[@class='table  m-0'])[1]//tr")
	private List<WebElement> statisticsTable;
	@FindBy(xpath = "(//table[@class='table  m-0'])[2]//tr")
	private List<WebElement> parameterTable;
	@FindBy(xpath = "(//table[@class='table  m-0'])[3]//tr")
	private List<WebElement> ESGTable;
	@FindBy(xpath = "(//table[@class='table  m-0'])[4]//tr")
	private List<WebElement> UniverseTable;

	public List<WebElement> getStatisticsTable() {
		return statisticsTable;
	}
	public List<WebElement> getParameterTable() {
		return parameterTable;
	}
	public List<WebElement> getESGTable() {
		return ESGTable;
	}
	public List<WebElement> getUniverseTable() {
		return UniverseTable;
	}
	public int countofStatiticsTableRow() {
		return statisticsTable.size();
	}
	public int countofParameterTableRow() {
		return parameterTable.size();
	}
	public int countofESGTableRow() {
		return ESGTable.size();
	}
	public int countofUniverseTableRow() {
		return UniverseTable.size();
	}


	public void clickPerformanceExpand() {
		clickusingJavascript(performanceExpand);
	}
	public List<String> returnListofLabels() {
		List<String> ChartLabelText = new LinkedList<>();
		for (WebElement ele : chartLabels) {
			highlight(ele);
			ChartLabelText.add(ele.getText());
		}
		clickusingJavascript(performanceExpand);
		return ChartLabelText;
	}


	public void clickstatisticsExpand() {
		highlight(statisticsExpand);
		clickusingJavascript(statisticsExpand);
	}
	public List<String> returnListofStatisticsHeader() {
		List<String> ChartLabelText = new LinkedList<>();
		for (WebElement ele : statisticsTableHeaders) {
			highlight(ele);
			ChartLabelText.add(ele.getText());
		}
		clickusingJavascript(statisticsExpand);
		ChartLabelText.remove(0);
		return ChartLabelText;
	}


	public void clickparameterExpand() {
		highlight(parameterExpand);
		clickusingJavascript(parameterExpand);
	}
	public List<String> returnListofparameterHeader() {
		List<String> ChartLabelText = new LinkedList<>();
		for (WebElement ele : parameterTableHeaders) {
			highlight(ele);
			ChartLabelText.add(ele.getText());
		}
		clickusingJavascript(parameterExpand);
		ChartLabelText.remove(0);
		return ChartLabelText;
	}


	public void clickesgExpand() {
		highlight(esgExpand);
		clickusingJavascript(esgExpand);
	}
	public List<String> returnListofesgHeader() {
		List<String> ChartLabelText = new LinkedList<>();
		for (WebElement ele : esgTableHeaders) {
			highlight(ele);
			ChartLabelText.add(ele.getText());
		}
		clickusingJavascript(esgExpand);
		ChartLabelText.remove(0);
		return ChartLabelText;
	}

	public void clickUniverseExpand() {
		highlight(UniverseExpand);
		clickusingJavascript(UniverseExpand);
	}
	public List<String> returnListofUniverseHeader() {
		List<String> ChartLabelText = new LinkedList<>();
		for (WebElement ele : UniverseTableHeaders) {
			highlight(ele);
			ChartLabelText.add(ele.getText());
		}
		clickusingJavascript(UniverseExpand);
		ChartLabelText.remove(0);
		return ChartLabelText;
	}

	public WebElement getStatisticsExpand() {
		return statisticsExpand;
	}
	public List<WebElement> getStatisticsTableHeaders() {
		return statisticsTableHeaders;
	}
	public WebElement getParameterExpand() {
		return parameterExpand;
	}
	public List<WebElement> getParameterTableHeaders() {
		return parameterTableHeaders;
	}
	public WebElement getEsgExpand() {
		return esgExpand;
	}
	public List<WebElement> getEsgTableHeaders() {
		return esgTableHeaders;
	}
	public WebElement getUniverseExpand() {
		return UniverseExpand;
	}
	public List<WebElement> getUniverseTableHeaders() {
		return UniverseTableHeaders;
	}
	public WebElement getPerformanceExpand() {
		return performanceExpand;
	}
	public List<WebElement> getChartLabels() {
		return chartLabels;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getVerifyButton() {
		return verifyButton;
	}
	public void sendFirstInputs(String value) throws AWTException {
		highlight(searchBox);
		clickusingJavascript(searchBox);
		switchToActiveElement(value);
		callRobot();
	}
	public void sendRemainingInputs(String secondvalue,String thirdValue) throws AWTException {
		clickusingJavascript(searchBox);
		searchBox.sendKeys(secondvalue);
		callRobot();
		clickusingJavascript(searchBox);
		searchBox.sendKeys(thirdValue);
		callRobot();
	}
	public void clickVerifyButton() {
		verifyButton.click();
	}
	public void clickSearchBox() {
		clickusingJavascript(searchBox);	}
}