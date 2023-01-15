package baseTest;

import libs.Utils;
import org.junit.Test;

import java.text.ParseException;

public class TC1_User1RegistrationPostCreationLogoutLoginTest extends BaseTest {

    private String date = Utils.getDateAndTimeFormatted();
    private String username = "boiaryntseva" + date;
    private String email = "125test" + date + "@test.com";
    private String profileName = username;
    private String welcomeText = "\"Hello " + username + ", your feed is empty.\n" +
            "Your feed displays the latest posts from the people you follow. If you don’t have any friends to follow that’s okay; you can use the “Search” feature in the top menu bar to find content written by people with similar interests and then follow them.\"";
    private String postTitle = "New post " + username + ".";
    private String postBody = "Good day " + date;
    private String successText = "New post successfully created.";

    @Test
    public void createPostTest() throws ParseException {
        loginPage.openLoginPage()
                .enterUserNameInRegisterForm(username)
                .enterEmailInRegisterForm(email)
                .enterPasswordInRegisterForm("123456qwerty")
                .clickOnSignUpButton()
                .checkRedirectToHomePage(profileName)
                .checkRedirectToHomePageWHenUserDoesntFollowAnyone(welcomeText)
                .getHeaderElement()
                .clickOnCreatePostButton()
                .checkRedirectToCreatePostPage()
                .fillInPostTitle(postTitle)
                .fillInPostBody(postBody)
                .savePost()
                .checkRedirectToPostPage()
                .checkPostWasCreated(successText, postTitle, username, date)
                .getHeaderElement()
                .clickOnSignOutButton()
                .checkRedirectToLoginPage()
                .enterUserNameIntoLoginInput(username)
                .enterPasswordIntoLoginInput("123456qwerty")
                .clickOnButtonSignIn()
                .checkRedirectToHomePage(username)
                .checkRedirectToHomePageWHenUserDoesntFollowAnyone(welcomeText)
                .getHeaderElement()
                .clickOnAvatarIcon()
                .checkRedirectToMytProfilePage()
                .checkMyProfilePageData(username, postTitle, date);

    }

}