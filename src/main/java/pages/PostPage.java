package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class PostPage extends ParentPage {
    HeaderElement headerElement = new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@data-icon='edit']")
    private WebElement editButton;
    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement deleteButton;
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement alertMessage;
    @FindBy(xpath = ".//h2")
    private WebElement postTitle;
    @FindBy(xpath = ".//img[@class='avatar-tiny']")
    private WebElement avatarIcon;
    @FindBy(xpath = ".//p[@class='text-muted small mb-4']")
    private WebElement postedBy;
    @FindBy(xpath = ".//i")
    private WebElement noteThisPostWasWritten;
    @FindBy(xpath = ".//div[@class='container py-md-5 container--narrow']/div[4]")
    private WebElement isThisPostUnique;
    @FindBy(xpath = ".//div[@class='body-content'][2]")
    private WebElement postBody;


    @Override
    String getRelativeUrl() {
        return "/post/.*";
    }

    public PostPage checkRedirectToPostPage() {
        checkUrlWithPattern();
        Assert.assertTrue("PostPage doesn't loaded", editButton.isDisplayed());
        return this;
    }

    public PostPage checkAlertMessage(String textAlert) {
        waitChatToBeHide();
        Assert.assertTrue("alert message doesn't display", isElementDisplayed(alertMessage));
        Assert.assertEquals("text in alert message is wrong", textAlert, alertMessage.getText());
        return this;
    }

    public PostPage checkPostTitle(String title) {
        Assert.assertEquals("text in TITLE is wrong", title, postTitle.getText());
        return this;
    }

    public PostPage checkInfoBlock(String title, String user, String infoPostBy, String infoWasWritten, String infoUnique, String body) {
        Assert.assertEquals("text in TITLE is wrong", title, postTitle.getText());
        Assert.assertTrue("avatar icon doesn't display", isElementDisplayed(avatarIcon));

         Assert.assertEquals("text in info block is wrong",
                infoPostBy, postedBy.getText().trim());

        Assert.assertEquals("text in info block is wrong",
                infoWasWritten, noteThisPostWasWritten.getText().trim());
        Assert.assertEquals("text in info block is wrong",
                infoUnique, isThisPostUnique.getText().trim());
        Assert.assertEquals("text in Body is wrong",
                body, postBody.getText().trim());

        return this;
    }

    public MyProfilePage clickOnDeletePost() {
        clickOnElement(deleteButton);
        return new MyProfilePage(webDriver);
    }

    public EditPostPage clickOnEditPost() {
        clickOnElement(editButton);
        waitChatToBeHide();
        return new EditPostPage(webDriver);
    }


}
