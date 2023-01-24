package post_test;

import base_test.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static libs.Util.getDateAndTimeFormatted;
import static libs.global_parameters.GlobalParametersProvider.getDefaultValidLogin;
import static libs.global_parameters.GlobalParametersProvider.getDefaultValidPassword;

public class TC3_CreationPost2EditingPost1DeletingPost1Test extends BaseTest {

    final String DATE = getDateAndTimeFormatted();
    final String TITLE_POST1 = "New post1 " + DATE;
    final String TITLE_POST_CHANGED = TITLE_POST1 + " SOME CHANGES";
    final String TITLE_POST2 = "New post2 " + DATE;
    final String BODY = "Good day " + DATE;
    final String POST_INFO_POSTED_BY = "Posted by " + getDefaultValidLogin() + " on " + Util.getDateBlockInfo(DATE);
    final String POST_INFO_WAS_WRITTEN = "Note: This post was written for All Users";
    final String POST_INFO_UNIQUE_POST = "Is this post unique? : no";
    final String SUCCESSFUL_MESSAGE_CREATE_POST = "New post successfully created.";
    final String SUCCESSFULLY_MESSAGE_DELETE_POST = "Post successfully deleted";


    public TC3_CreationPost2EditingPost1DeletingPost1Test() throws ParseException {
    }

    @Before
    public void precondition() {
        loginPage.openLoginPage()
                .enterUserNameIntoLoginInput(getDefaultValidLogin())
                .enterPasswordIntoLoginInput(getDefaultValidPassword())
                .clickOnButtonSignIn()
                .checkIsRedirectToHomePage()

                .getHeaderElement().clickOnButtonCreatePost()
                .checkRedirectToCreatePostPage()
                .fillInPostTitle(TITLE_POST1)
                .fillInPostBody(BODY)
                .savePost()
                .checkRedirectToPostPage()
                .checkAlertMessage(SUCCESSFUL_MESSAGE_CREATE_POST)
                .checkInfoBlock(TITLE_POST1, getDefaultValidLogin(), POST_INFO_POSTED_BY, POST_INFO_WAS_WRITTEN, POST_INFO_UNIQUE_POST, BODY)
                .getHeaderElement().clickOnMyProfile()
                .checkToRedirectToMyProfilePage()
                .checkPostWasSave(TITLE_POST1)
                .checkPostNotExist(TITLE_POST2);
    }

    @Test
    public void createPost() {

        final String SUCCESSFUL_MESSAGE_EDIT_POST = "Post successfully updated.";

        homePage.getHeaderElement().clickOnButtonCreatePost()
                .checkRedirectToCreatePostPage()
                .fillInPostTitle(TITLE_POST2)
                .fillInPostBody(BODY)
                .savePost()
                .checkRedirectToPostPage()
                .checkAlertMessage(SUCCESSFUL_MESSAGE_CREATE_POST)
                .checkInfoBlock(TITLE_POST2, getDefaultValidLogin(), POST_INFO_POSTED_BY, POST_INFO_WAS_WRITTEN, POST_INFO_UNIQUE_POST, BODY)
                .getHeaderElement().clickOnMyProfile()
                .checkPostWasSave(TITLE_POST2)
                .checkPostWasSave(TITLE_POST1)

                .editPost(TITLE_POST1, TITLE_POST_CHANGED, SUCCESSFUL_MESSAGE_EDIT_POST)
                .getHeaderElement().clickOnMyProfile()
                .checkToRedirectToMyProfilePage()
                .checkPostWasSave(TITLE_POST_CHANGED)
                .checkPostNotExist(TITLE_POST1)
                .checkPostWasSave(TITLE_POST2)

                .deletePost(TITLE_POST_CHANGED, SUCCESSFULLY_MESSAGE_DELETE_POST)
                .checkPostWasSave(TITLE_POST2)
                .checkPostNotExist(TITLE_POST_CHANGED);

    }

    @After
    public void postcondition() {

        homePage.getHeaderElement().clickOnMyProfile()
                .checkToRedirectToMyProfilePage()
                .deletePost(TITLE_POST2, SUCCESSFULLY_MESSAGE_DELETE_POST)
                .checkPostNotExist(TITLE_POST2);

    }
}
