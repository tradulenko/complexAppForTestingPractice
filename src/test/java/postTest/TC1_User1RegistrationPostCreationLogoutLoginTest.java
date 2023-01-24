package postTest;

import baseTest.BaseTest;
import libs.ConfigPropertiesHidden;
import libs.Utils;
import org.junit.Test;
import pages.PropertiesProvider;

import java.text.ParseException;

public class TC1_User1RegistrationPostCreationLogoutLoginTest extends BaseTest {

    final String date = Utils.getDateAndTimeFormatted();
    final String username = "boiaryntseva" + date;
    final String email = "125test" + date + "@test.com";
    final String profileName = username;
    final String welcomeText = "Hello " + username + ", your feed is empty.\n" +
            "Your feed displays the latest posts from the people you follow. If you don’t have any friends to follow that’s okay; you can use the “Search” feature in the top menu bar to find content written by people with similar interests and then follow them.";
    final String postTitle = "New post " + username + ".";
    final String postBody = "Good day " + date;
    final String successText = "New post successfully created.";
    final String availabilityMessage = "Note: This post was written for All Users";


    @Test
    public void createPostTest() throws ParseException {
        loginPage.openLoginPage()
                .enterUserNameInRegisterForm(username)
                .enterEmailInRegisterForm(email)
                .enterPasswordInRegisterForm(defaultValidPassword)
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
                .checkPostWasCreated(successText, postTitle, username, date, availabilityMessage, postBody)
                .getHeaderElement()
                .clickOnSignOutButton()
                .checkRedirectToLoginPage()
                .enterUserNameIntoLoginInput(username)
                .enterPasswordIntoLoginInput(defaultValidPassword)
                .clickOnButtonSignIn()
                .checkRedirectToHomePage(username)
                .checkRedirectToHomePageWHenUserDoesntFollowAnyone(welcomeText)
                .getHeaderElement()
                .clickOnMyProfileIcon()
                .checkRedirectToMytProfilePage()
                .checkMyProfilePageData(username, postTitle, date);

    }

}