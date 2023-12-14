package cucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Steps {
	
private SHAFT.GUI.WebDriver driver ; 
	
	@Given("I Open The Browser")
	public void i_open_the_browser() {
		driver = new SHAFT.GUI.WebDriver() ; 
	}
	
	@When("I Navigate To {string}")
	public void  I_Navigate_To (String url) {
		driver.browser().navigateToURL(url);
	}

	@Then("I assert That Chosen Country Is KSA")
	public void I_Assert_That_ChosenCountry_Is_KSA(){
		By saFlag = By.xpath("//div[@id='country']//img[@alt='sa']");
		driver.element().assertThat(saFlag).exists().perform();
	}

	@Then("I assert That Package {string} Price Equals {string} {string}")
		public void I_Assert_Package_Price(String packageName , String packagePrice , String packageCurrency) {
		By packageNameElement = By.id("name-"+packageName.toLowerCase()+"");
		By packagePriceElement = By.xpath("//*[@id='currency-"+packageName.toLowerCase()+"']//b");
		By packageCurrencyElement = By.xpath("//*[@id='currency-"+packageName.toLowerCase()+"']//i");
		driver.element().assertThat(packageNameElement).text().isEqualTo(packageName).perform();
		driver.element().assertThat(packagePriceElement).text().isEqualTo(packagePrice).perform();
		driver.element().assertThat(packageCurrencyElement).text().contains(packageCurrency).perform();
	}


	@When("I Change The Country To Bahrain")
	public void I_Change_The_Country_To_Bahrain(){
		By changeCountryButton = By.xpath("//div[@class='head-links']//a[@id='country-btn']");
		By BahrainButton = By.xpath("//div[@id='country-selct']//a[@id='bh']");
	driver.element().click(changeCountryButton);
	driver.element().click(BahrainButton);



	}

	@When("I Change The Country To Kuwait")
	public void I_Change_The_Country_To_kuwait(){
		By changeCountryButton = By.xpath("//div[@class='head-links']//a[@id='country-btn']");
		By kuwaitButton = By.xpath("//div[@id='country-selct']//a[@id='kw']");
		driver.element().click(changeCountryButton);
		driver.element().click(kuwaitButton);

	}
}
