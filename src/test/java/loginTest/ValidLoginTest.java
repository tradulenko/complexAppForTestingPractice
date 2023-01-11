package loginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class ValidLoginTest extends BaseTest {

    @Test
    public void loginValidUser() {
        loginPage.openLoginPage()
                .enterUserNameIntoLoginInput(login)
                .enterPasswordIntoLoginInput(password)
                .clickOnButtonSignIn();

        Assert.assertTrue("Button SignOut doesn't displayed", homePage.getHeaderElement().isButtonSignOutDisplayed());
    }
}
