package pomDesignPatternTests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PackagesPage;

public class Tests {

    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private PackagesPage packagesPage;

    @BeforeClass(description = "Setup Browser Instance.")
    public void BeforeClass(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("testData.json");
    }
    @BeforeMethod()
    public void BeforeMethod(){
        packagesPage = new PackagesPage(driver);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void verifyPackageTypeAndPrice(){
        packagesPage.navigateTo(testData.getTestData("url"));
        packagesPage.verifyThatchosenCountryIsKsa();
        packagesPage.verifyPackageNameAndPrice("LITE","15","SAR");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","25","SAR");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","60","SAR");
        packagesPage.changingCountryToBahrain();
        packagesPage.verifyPackageNameAndPrice("LITE","2","BHD");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","3","BHD");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","6","BHD");
        packagesPage.changeCountryToKuwait();
        packagesPage.verifyPackageNameAndPrice("LITE","1.2","KWD");
        packagesPage.verifyPackageNameAndPrice("CLASSIC","2.5","KWD");
        packagesPage.verifyPackageNameAndPrice("PREMIUM","4.8","KWD");
    }




}
