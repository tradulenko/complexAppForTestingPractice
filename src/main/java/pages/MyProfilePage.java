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
    private WebElement postedByInfoTextOnProfile;

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

    public MyProfilePage checkMyProfilePageData(String username, String postTitle, String date) throws ParseException {
        System.out.println(postedByInfoTextOnProfile.getText());
        Assert.assertTrue("Avatar image is not displayed", isElementDisplayed(avatarImage));
        Assert.assertTrue("Profile name does not match", profileName.getText().matches(username));
        Assert.assertTrue("'Post information is wrong/empty", postedByInfoTextOnProfile.getText().matches(postTitle + " on " + Utils.formatDateToAnotherFormat(date)));
        Assert.assertTrue("Number of posts is more then 1", numberOfExistingPost.getText().contains("1"));
        Assert.assertTrue("Number of followers is > 0", numberOfFollowers.getText().contains("0"));
        Assert.assertTrue("Number of people following is more then 1", numberOfPeopleFollowing.getText().contains("0"));

        return this;
    }
}
