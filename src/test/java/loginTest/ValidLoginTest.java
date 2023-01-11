package loginTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ValidLoginTest extends BaseTest {

    @Test
    public void loginValidUser() {
        loginPage.openLoginPage()
                .enterUserNameIntoLoginInput(defaultValidLogin)
                .enterPasswordIntoLoginInput(defaultValidPassword)
                .clickOnButtonSignIn();

        Assert.assertTrue("Button SignOut doesn't displayed", homePage.getHeaderElement().isButtonSignOutDisplayed());
    }
}
