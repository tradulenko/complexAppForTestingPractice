package baseTest;

import libs.Utils;
import org.junit.Test;

public class User1RegistrationPostCreationLogoutLoginTest extends BaseTest {

    private String username = "boiaryntseva" + Utils.getDateAndTimeFormatted();
    private String email = "125test" + Utils.getDateAndTimeFormatted() + "@test.com";
    private String profileName = username;
    private String welcomeText = "\"Hello " + username + ", your feed is empty.\n" +
            "Your feed displays the latest posts from the people you follow. If you don’t have any friends to follow that’s okay; you can use the “Search” feature in the top menu bar to find content written by people with similar interests and then follow them.\"";

    @Test
    public void createPostTest() {
        loginPage.openLoginPage()
                .enterUserNameInRegisterForm(username)
                .enterEmailInRegisterForm(email)
                .enterPasswordInRegisterForm("123456qwerty")
                .clickOnSignUpButton()
                .checkRedirectToHomePage()
                .checkRedirectToHomePageAfterRegistration(welcomeText, profileName)
                .getHeaderElement()
                .clickOnCreatePostButton()
                .checkRedirectToCreatePostPage();

//                .fillInPostTitle("title")
//                .fillInPostBody("Body")
//                .savePost()
//                .checkRedirectToPostPage();
    }

}