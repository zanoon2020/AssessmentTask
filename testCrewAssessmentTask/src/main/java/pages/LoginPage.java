package pages;


    import com.shaft.driver.SHAFT;
    import io.qameta.allure.Step;
    import org.openqa.selenium.By;

public class LoginPage {
        private SHAFT.GUI.WebDriver driver;
        public LoginPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }


        private By loginIdInputField=By.name("username");
        private By invalidEmailFormatMessageHolder = By.xpath("//span[@class='error-msg']");
        private By IdNotExistMessageHolder = By.xpath("//span[@class='error-msg-top']");
        private By enterSignCodeMessageHolder = By.xpath("//div[@class='sign-in-DescMain']");
        private By otp = By.xpath("//div[@class='otp-div']");

        private By nextButton = By.xpath("//button[@type='submit']");

    @Step("Navigate To Login Page")
    public void navigateToLoginPage(String url) {
        driver.browser().navigateToURL(url);
    }


        public void verifyInvalidEmailFormatWarning(){
            driver.element().type(loginIdInputField,"invalid");
            driver.assertThat().element(invalidEmailFormatMessageHolder).text().isEqualTo("Please enter a correct email address format").perform();
        }


        public void verifyLoginIdNotExistError(String InvalidEmail){
            driver.element().type(loginIdInputField,InvalidEmail);
            driver.element().click(nextButton);
            driver.assertThat().element( IdNotExistMessageHolder ).text().contains("Login ID does not exist.").perform();
        }

    public void verifyLoginWithValidUser(String validEmail){
        driver.element().type(loginIdInputField,validEmail);
        driver.element().click(nextButton);
        driver.assertThat().element( enterSignCodeMessageHolder ).text().contains("Please enter the sign-in code").perform();
        driver.assertThat().element( otp ).exists().perform();

    }

}
