package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@name='username' and @placeholder='Username']")
    private WebElement inputUserNameHeader;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputUserPasswordHeader;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSingIn;

    @FindBy(xpath = ".//button[text()='Sign Out']")
    private WebElement buttonSingOut;

    @FindBy(xpath = ".//div[@Class='alert alert-danger text-center']")
    private WebElement messageInvalidUserPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    @Step
    public LoginPage openLoginPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened");
            logger.info(baseUrl);
        } catch (Exception e) {
            logger.error("Can not work with site");
            Assert.fail("Can not work with site");
        }
        return this;
    }

    @Step
    public LoginPage enterUserNameIntoLoginInput(String userName) {
        enterTextIntoElement(inputUserNameHeader, userName);
        return this;
    }

    @Step
    public LoginPage enterPasswordIntoLoginInput(String password) {
        enterTextIntoElement(inputUserPasswordHeader, password);
        return this;
    }

    @Step
    public HomePage clickOnButtonSignIn() {
        clickOnElement(buttonSingIn);
        return new HomePage(webDriver);
    }

    public boolean isMessageInvalidCredsDisplayed() {
        return isElementDisplayed(messageInvalidUserPassword);
    }
}
