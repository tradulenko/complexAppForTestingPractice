package loginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.CommonActionsWithElements;

@RunWith(JUnitParamsRunner.class)

public class InvalidLoginAndPasswordTest extends BaseTest {

    final static String USER_NAME = "qaauto";
    final static String INVALID_USER_NAME = "qa";
    final static String PASSWORD = "123456qwerty";
    final static String INVALID_PASSWORD = "123456";
    final static String COMMA = ",";


    @Test
    @Parameters({
            USER_NAME + COMMA + INVALID_PASSWORD,
            INVALID_USER_NAME + COMMA + PASSWORD,
            INVALID_USER_NAME + COMMA + INVALID_PASSWORD

    })
    @TestCaseName("Invalid Login and Password : valid login= {0} & invalid pass = {1},invalid login = {2} & valid pass = {3},invalid login = {2} & invalid pass = {1} ")
    public void invalidLoginAndPasswordWithParameters(String userName, String password) {
        loginPage
                .openLoginPage()
                .enterUserNameIntoLoginInput(userName)
                .enterPasswordIntoLoginInput(password)
                .clickOnButtonSignIn();
        Assert.assertTrue("Message 'Invalid username / password' is displayed "
                , loginPage.isMessageInvalidCredsDisplayed());

    }

    @Test
    public void loginValidUser() {
        loginPage.openLoginPage()
                .enterUserNameIntoLoginInput(CommonActionsWithElements.configPropertiesHidden.DEFAULT_LOGIN())
                .enterPasswordIntoLoginInput(CommonActionsWithElements.configPropertiesHidden.DEFAULT_PASSWORD())
                .clickOnButtonSignIn();

        Assert.assertTrue("Button SignOut doesn't displayed", homePage.headerElement.isButtonSignOutDisplayed());
    }
}
