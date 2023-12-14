package pages;

    import com.shaft.driver.SHAFT;
    import io.qameta.allure.Step;
    import org.openqa.selenium.By;

public class PackagesPage {
        private SHAFT.GUI.WebDriver driver;
        public  PackagesPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }
    private By saFlag = By.xpath("//div[@id='country']//img[@alt='sa']");
    private By packageNameElement (String packageName){
       return By.id("name-"+packageName.toLowerCase()+"");
    }
    private By packagePriceElement (String packageName){
        return By.xpath("//*[@id='currency-"+packageName.toLowerCase()+"']//b");
    }
    private By packageCurrencyElement (String packageName){
       return  By.xpath("//*[@id='currency-"+packageName.toLowerCase()+"']//i");
    }
    private By changeCountryButton = By.xpath("//div[@class='head-links']//a[@id='country-btn']");
    private By BahrainButton = By.xpath("//div[@id='country-selct']//a[@id='bh']");
    private By kuwaitButton = By.xpath("//div[@id='country-selct']//a[@id='kw']");



     @Step("Navigation To Supscription Packages Page")
    public void  navigateTo (String url) {
        driver.browser().navigateToURL(url);
    }
    @Step("Confirming That Chosen Country Is KSA")
    public void verifyThatchosenCountryIsKsa(){
        driver.element().assertThat(saFlag).exists().perform();
    }
    @Step("Verifying That Package {packageName} Price Is {packagePrice} {packageCurrency}")
    public void verifyPackageNameAndPrice(String packageName , String packagePrice , String packageCurrency) {
        driver.element().assertThat(packageNameElement(packageName)).text().isEqualTo(packageName).perform();
        driver.element().assertThat(packagePriceElement(packageName)).text().isEqualTo(packagePrice).perform();
        driver.element().assertThat(packageCurrencyElement(packageName)).text().contains(packageCurrency).perform();
    }
    @Step("Changing Country To Bahrain")

    public void changingCountryToBahrain(){
        driver.element().click(changeCountryButton);
        driver.element().click(BahrainButton);
    }

    @Step("Changing Country To Kuwait")
    public void changeCountryToKuwait(){
        driver.element().click(changeCountryButton);
        driver.element().click(kuwaitButton);
    }

}
