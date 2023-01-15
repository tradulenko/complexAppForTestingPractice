package pages;

import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

import java.text.ParseException;

public class PostPage extends ParentPage {

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    @FindBy(xpath = ".//*[@data-icon='edit']")
    private WebElement editButton;

    @FindBy(xpath = ".//body/div[2]/div[1]")
    private WebElement successMessage;

    @FindBy(xpath = ".//body/div[2]/div[2]/h2")
    private WebElement createdPostTitle;

    @FindBy(xpath = ".//*[@class='avatar-tiny']")
    private WebElement avatarIcon;

    // @FindBy(xpath = ".//body/div[2]/p/a[1]")
    @FindBy(xpath = " .//p[@class='text-muted small mb-4']")
    private WebElement postedByInfoText;

    @Override
    String getRelativeUrl() {
        return "/post/.*";
    }


    public PostPage checkRedirectToPostPage() {
        checkUrlWithPattern();
        Assert.assertTrue(editButton.isDisplayed());
        Assert.assertTrue("Avatar icon is missing", isElementDisplayed(avatarIcon));
        return this;
    }

    public PostPage checkPostWasCreated(String successText, String postTitleText, String username, String date) throws ParseException {
        Assert.assertTrue("Success message is not displayed", successMessage.getText().matches(successText));
        Assert.assertTrue("Post title doesn't match", createdPostTitle.getText().matches(postTitleText));
        Assert.assertTrue("'Posted by' text is not there/wrong", postedByInfoText.getText().matches("Posted by " + username + " on " + Utils.formatDateToAnotherFormat(date)));
        return this;
    }

}
