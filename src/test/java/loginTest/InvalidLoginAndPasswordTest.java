package loginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.PropertiesProvider;


@RunWith(JUnitParamsRunner.class)

public class InvalidLoginAndPasswordTest extends BaseTest {

    final static String INVALID_USER_NAME = "qa";
    final static String INVALID_PASSWORD = "123456";

    @Test
    @Parameters(method = "provideParameters")
    @TestCaseName("Invalid Login and Password : valid login= {0} & invalid pass = {1},invalid login = {2} & valid pass = {3},invalid login = {2} & invalid pass = {1} ")
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
                new Object[]{login, INVALID_PASSWORD},
                new Object[]{INVALID_USER_NAME, password},
                new Object[]{INVALID_USER_NAME, INVALID_PASSWORD}

        };
    }
}
