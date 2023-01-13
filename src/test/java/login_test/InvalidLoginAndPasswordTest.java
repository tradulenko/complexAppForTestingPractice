package login_test;

import base_test.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import libs.global_parameters.GlobalParametersProvider;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)

public class InvalidLoginAndPasswordTest extends BaseTest {

    final static String INVALID_USER_NAME = "qa";
    final static String INVALID_PASSWORD = "123456";

    @Test
    @Parameters(method = "provideParameters")
    @TestCaseName("Invalid Login and Password: login = {0} , password = {1}")
    public void invalidLoginAndPasswordWithParameters(String userName, String userPassword) {
        loginPage
                .openLoginPage()
                .enterUserNameIntoLoginInput(userName)
                .enterPasswordIntoLoginInput(userPassword)
                .clickOnButtonSignIn();
        Assert.assertTrue("Message 'Invalid username / password' is displayed "
                , loginPage.isMessageInvalidCredsDisplayed());

    }

    public static Object[][] provideParameters() {
        return new Object[][]{
                new Object[]{GlobalParametersProvider.getDefaultValidLogin(), INVALID_PASSWORD},
                new Object[]{INVALID_USER_NAME, GlobalParametersProvider.getDefaultValidPassword()},
                new Object[]{INVALID_USER_NAME, INVALID_PASSWORD}
        };
    }
}
