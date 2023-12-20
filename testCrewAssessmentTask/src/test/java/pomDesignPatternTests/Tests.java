package pomDesignPatternTests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PackagesPage;
import pages.VoucherPage;

public class Tests {

    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private PackagesPage packagesPage;
    private LoginPage loginPage ;
    private VoucherPage voucherPage;
    @BeforeClass(description = "Setup Browser Instance.")
    public void BeforeClass(){
        testData = new SHAFT.TestData.JSON("testData.json");
    }
    @BeforeMethod()
    public void BeforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        packagesPage = new PackagesPage(driver);
        loginPage = new LoginPage(driver);
        voucherPage = new VoucherPage(driver);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test (description = "Verify Subscription Packages's Type And Price For Saudi Arabia ")
    public void _01verifyPackageTypeAndPriceForSaudiaArabia(){
        packagesPage.navigateTo(testData.getTestData("url"));
        packagesPage.verifyThatchosenCountryIsKsa();
        packagesPage.verifyPackageNameAndPrice("LITE","15","SAR");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","25","SAR");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","60","SAR");
    }

    @Test (description = "Verify Subscription Packages Type And Price For Bahrain ")
    public void _02verifyPackageTypeAndPriceForBahrain(){
        packagesPage.navigateTo(testData.getTestData("url"));
        packagesPage.changingCountryToBahrain();
        packagesPage.verifyPackageNameAndPrice("LITE","2","BHD");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","3","BHD");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","6","BHD");
    }

    @Test (description = "Verify Subscription Packagess Type And Price For Kuwait ")
    public void _03verifyPackageTypeAndPriceForKuwait(){
        packagesPage.navigateTo(testData.getTestData("url"));
        packagesPage.changeCountryToKuwait();
        packagesPage.verifyPackageNameAndPrice("LITE","1.2","KWD");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","2.5","KWD");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","4.8","KWD");
    }

    @Test(description = "negative Scenario : Logging With Invalid Email Format")
    public void _04verifyInvalidWrongEmailErrorMessage(){
        loginPage.navigateToLoginPage(testData.getTestData("signInPage"));
        loginPage.verifyInvalidEmailFormatWarning();
    }

    @Test(description = "negative Scenario : Logging With Non Registered Email")
    public void _05verifyLoginIdNotExistError(){
        loginPage.navigateToLoginPage(testData.getTestData("signInPage"));
        loginPage.verifyLoginIdNotExistError("email@email2.com");
    }

    @Test(description = "positive Scenario : Logging With Registered Email")
    public void _06verifyLoginWithValidEmail(){
        loginPage.navigateToLoginPage(testData.getTestData("signInPage"));
        loginPage.verifyLoginWithValidUser("email@email.com");
    }


    @Test(description = "Negative Scnario : Entering Invalid Voucher Code ")

    public void _07verifyRedeemingWithWrongVoucherCode(){
      voucherPage.navigateToVoucherPage(testData.getTestData("voucherPage"));
      voucherPage.verifyInvalidVoucher("122023");
    }



}
