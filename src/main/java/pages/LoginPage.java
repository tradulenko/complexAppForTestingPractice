package pages;

import io.qameta.allure.Step;
import libs.Utils;
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

    @FindBy(xpath = ".//*[@id='username-register']")
    private WebElement inputUserNameRegister;

    @FindBy(xpath = ".//*[@id='password-register']")
    private WebElement inputUserPasswordRegister;

    @FindBy(xpath = ".//*[@id='email-register']")
    private WebElement emailRegister;

    @FindBy(xpath = ".//div//button[@type='submit']")
    private WebElement buttonSignUp;

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

    public LoginPage checkRedirectToLoginPage() {
        checkUrl();
        Assert.assertTrue("Login Page is not loaded", isElementDisplayed(buttonSingIn));
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

    public LoginPage enterUserNameInRegisterForm(String name) {
        enterTextIntoElement(inputUserNameRegister, name);
        return this;
    }

    public LoginPage enterEmailInRegisterForm(String email) {
        enterTextIntoElement(emailRegister, email);
        return this;
    }

    public LoginPage enterPasswordInRegisterForm(String password) {
        enterTextIntoElement(inputUserPasswordRegister, password);
        return this;
    }

    public HomePage clickOnSignUpButton() {
        Utils.waitABit(2);
        clickOnElement(buttonSignUp);
        return new HomePage(webDriver);
    }
}
