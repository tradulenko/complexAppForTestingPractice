package login_test;

import static libs.global_parameters.GlobalParametersProvider.getDefaultValidLogin;
import static libs.global_parameters.GlobalParametersProvider.getDefaultValidPassword;

import base_test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ValidLoginTest extends BaseTest {

    @Test
    public void loginValidUser() {
        loginPage.openLoginPage()
                .enterUserNameIntoLoginInput(getDefaultValidLogin())
                .enterPasswordIntoLoginInput(getDefaultValidPassword())
                .clickOnButtonSignIn();

        Assert.assertTrue("Button SignOut doesn't displayed", homePage.getHeaderElement().isButtonSignOutDisplayed());
    }
}
