package pages;

    import com.shaft.driver.SHAFT;
    import io.qameta.allure.Step;
    import org.openqa.selenium.By;

public class VoucherPage {
        private SHAFT.GUI.WebDriver driver;
        public  VoucherPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }

    private By voucherInputField=By.name("username");
    private By redeemButton = By.xpath("//button[@type='submit']");
    private By invalidVoucherMessageHolder = By.xpath("//div[@class='error-msg']");
    @Step("Navigate To Voucher Page")
    public void  navigateToVoucherPage (String url) {
        driver.browser().navigateToURL(url);
    }

    public void verifyInvalidVoucher(String InvalidCode){
        driver.element().type(voucherInputField,InvalidCode);
        driver.element().click(redeemButton);
        driver.assertThat().element(invalidVoucherMessageHolder).text().contains("Invalid voucher or promo code").perform();
    }


}
