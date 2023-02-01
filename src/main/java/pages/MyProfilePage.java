package pages;

import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;

public class MyProfilePage extends ParentPage {
    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//h2")
    private WebElement profileName;
    @FindBy(xpath = ".//img[@class='avatar-small']")
    private WebElement avatarImage;
    @FindBy(xpath = ".//div[@class='list-group']")
    private WebElement listOfPostsPostedByUser;
    @FindBy(xpath = ".//a[contains(text(),'Posts')]")
    private WebElement numberOfExistingPost;
    @FindBy(xpath = ".//a[contains(text(),'Followers')]")
    private WebElement numberOfFollowers;
    @FindBy(xpath = ".//a[contains(text(),'Following')]")
    private WebElement numberOfPeopleFollowing;

    @Override
    String getRelativeUrl() {
        return "/profile/.*";
    }

    public MyProfilePage checkRedirectToMytProfilePage() {
        checkUrlWithPattern();
        return this;
    }

    public MyProfilePage isAvatarImageDisplayed() {
        Assert.assertTrue("Avatar image is not displayed", isElementDisplayed(avatarImage));
        return this;
    }

    public MyProfilePage isProfileNameMatchingUsername(String username) {
        Assert.assertEquals("Profile name does not match", profileName.getText(), username);
        return this;
    }

    public MyProfilePage isPostTitleCorrect(String postTitle, String date) throws ParseException {
        Assert.assertTrue("'Post information is wrong/empty", listOfPostsPostedByUser.getText().matches(postTitle + " on " + Utils.formatDateToAnotherFormat(date)));
        return this;
    }

    public MyProfilePage isNumberOfPostsOne() {
        Assert.assertTrue("Number of posts is more then 1", numberOfExistingPost.getText().contains("1"));
        return this;
    }

    public MyProfilePage isNumberOfFollowersAndPeopleFollowingZero() {
        Assert.assertTrue("Number of followers is > 0", numberOfFollowers.getText().contains("0"));
        Assert.assertTrue("Number of people following is more then 1", numberOfPeopleFollowing.getText().contains("0"));
        return this;
    }

    public MyProfilePage checkMyProfilePageData(String username, String postTitle, String date) throws ParseException {
        isAvatarImageDisplayed();
        isProfileNameMatchingUsername(username);
        isPostTitleCorrect(postTitle,date);
        isNumberOfPostsOne();
        isNumberOfFollowersAndPeopleFollowingZero();

        return this;
    }
}
