package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import driverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CompareMenu;
import pom.Dashboard;
import pom.LoginPage;
import utilities.Utilities;

public class TC_1ComparePageValidation extends BaseClass {
	List<String> portfoliosToBeSelected;
	@Given("that user launching the {string} environment")
	public void thatUserLaunchingTheEnvironment(String url) throws IOException {
		DriverManager.getInstance().getDriver().get(Utilities.getInstance().readPropertyFile(url));
	}
	@Given("the user click on login Button and navigates to the Login Page")
	public void theUserClickOnLoginButtonAndNavigatesToTheLoginPage() {
		Dashboard.getInstance().acceptCookies();
		Dashboard.getInstance().clickLoginInButton();
	}
	@Given("the user pass {string} and {string} from property file and click login Button")
	public void theUserPassAndFromPropertyFileAndClickLoginButton(String username, String password) throws IOException {
		LoginPage.getInstance().enterUsername(Utilities.getInstance().readPropertyFile(username));
		LoginPage.getInstance().enterPassword(Utilities.getInstance().readPropertyFile(password));
	}
	@Given("that user is on HomePage and Click Compare Menu")
	public void thatUserIsOnHomePageAndClickCompareMenu() {
		Dashboard.getInstance().clickCompareMenu();
	}
	@Given("the user Select Portfolios from the Selectable Dropdown as mentioned Below")
	public void theUserSelectPortfoliosFromTheSelectableDropdownAsMentionedBelow(io.cucumber.datatable.DataTable dataTable) throws AWTException {
		List<List<String>> asLists = dataTable.asLists();
		List<String> list = asLists.get(0);
		CompareMenu.getInstance().sendFirstInputs(list.get(0));
		CompareMenu.getInstance().sendRemainingInputs(list.get(1),list.get(2));
	}
	@Given("the user click on View Result Button")
	public void theUserClickOnViewResultButton() {
		CompareMenu.getInstance().clickVerifyButton();
	}
	@When("the user click and expand the Performance Chart")
	public void theUserClickAndExpandThePerformanceChart() {
		CompareMenu.getInstance().clickPerformanceExpand();
	}
	@Then("the user should see the Chart Labels as per Selected Order")
	public void theUserShouldSeeTheChartLabelsAsPerSelectedOrder() {
		List<String> returnListofLabels = CompareMenu.getInstance().returnListofLabels();
		for (String string : returnListofLabels) {
			System.out.println(string);
		}
		for (String string : portfoliosToBeSelected) {
			System.out.println("---------Already stored");
			System.out.println(string);
		}
		assertThat(portfoliosToBeSelected).hasSameElementsAs(returnListofLabels);
	}
	@When("the user click and expand the Statistics Menu")
	public void theUserClickAndExpandTheStatisticsMenu() {
		CompareMenu.getInstance().clickstatisticsExpand();
	}
	@Then("the user should see Table headers of {string} should be in the order of Portfolios Selected")
	public void theUserShouldSeeTableHeadersShouldBeInTheOrderOfPortfoliosSelected(String key) {
		if(key.equalsIgnoreCase("Statistics")) {
			List<String> returnListofLabels = CompareMenu.getInstance().returnListofStatisticsHeader();
			assertThat(portfoliosToBeSelected).hasSameElementsAs(returnListofLabels);
		}else if(key.equalsIgnoreCase("Parameters")) {
			List<String> returnListofLabels = CompareMenu.getInstance().returnListofparameterHeader();
			assertThat(portfoliosToBeSelected).hasSameElementsAs(returnListofLabels);
		}else if(key.equalsIgnoreCase("ESG")) {
			List<String> returnListofLabels = CompareMenu.getInstance().returnListofesgHeader();
			assertThat(portfoliosToBeSelected).hasSameElementsAs(returnListofLabels);
		}else if(key.equalsIgnoreCase("Universe")) {
			List<String> returnListofLabels = CompareMenu.getInstance().returnListofUniverseHeader();
			assertThat(portfoliosToBeSelected).hasSameElementsAs(returnListofLabels);
		}
	}
	@When("the user click and expand the Parameters Menu")
	public void theUserClickAndExpandTheParametersMenu() {
		CompareMenu.getInstance().clickparameterExpand();
	}
	@When("the user click and expand the ESG Menu")
	public void theUserClickAndExpandTheESGMenu() {
		CompareMenu.getInstance().clickesgExpand();
	}
	@When("the user click and expand the Universe Menu")
	public void theUserClickAndExpandTheUniverseMenu() {
		CompareMenu.getInstance().clickUniverseExpand();
	}
	@Then("the user should see {int} accordance as mentioned Below")
	public void theUserShouldSeeAccordanceAsMentionedBelow(Integer int1, io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}
	@Then("the user should see Table should have more than {string} Rows")
	public void theUserShouldSeeTableShouldHaveMoreThanRows(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
