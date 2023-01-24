package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='list-group']")
    private WebElement listOfPosts;
    @FindBy(xpath = ".//img[@class='avatar-small']")
    private WebElement avatar;
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement messageOnDelete;
    private String locatorListPostsWithTitle = ".//a/strong[text()='%s']";

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/profile/.*";
    }

    public MyProfilePage checkToRedirectToMyProfilePage() {
        checkUrlWithPattern();
        Assert.assertTrue("MyProfile page doesn't loaded", isElementDisplayed(avatar));
        return this;
    }

    public MyProfilePage checkMessageOnDelete(String message) {
        Assert.assertEquals("Wrong text message after click on Delete post", message, messageOnDelete.getText());
        return this;
    }

    public MyProfilePage deletePost(String title, String message) {

        List<WebElement> listOfSearchingPost = getPostsListWithTitle(title);
        while (listOfSearchingPost.size() != 0) {
            clickOnElement(listOfSearchingPost.get(0));
            waitChatToBeHidden();
            new PostPage(webDriver).checkRedirectToPostPage()
                    .checkPostTitle(title)
                    .clickOnDeletePost()
                    .checkToRedirectToMyProfilePage()
                    .checkMessageOnDelete(message);
            logger.info("Post was deleted with title '" + title + "'");
            listOfSearchingPost = getPostsListWithTitle(title);
        }
        logger.info("All posts were deleted with title '" + title + "'");
        return this;
    }

    public EditPostPage editPost(String title, String newTitle, String messageEdit) {
        waitChatToBeHidden();
        List<WebElement> listPostWithTitle = getPostsListWithTitle(title);
        if (!listPostWithTitle.isEmpty()) {
            clickOnElement(listPostWithTitle.get(0));
            waitChatToBeHidden();
            new PostPage(webDriver).clickOnEditPost()
                    .checkToRedirectToEditePostPage()
                    .enterNewTextTitleInEdit(newTitle)
                    .clickOnSaveUpdates()
                    .checkTextMessageAfterEdit(messageEdit);
            logger.info("post '" + title + "' was changed to '" + newTitle + "'");
        } else {
            logger.info("post with title '" + title + "' wasn't find");
        }
        return new EditPostPage(webDriver);
    }

    public MyProfilePage checkPostWasSave(String title) {
        waitChatToBeHidden();
        Assert.assertEquals("Wrong number of posts after creating/editing ", 1, getPostsListWithTitle(title).size());
        Assert.assertTrue("Titles of post don't equals", getPostsListWithTitle(title).get(0).getText().equals(title));

        return this;
    }

    public MyProfilePage checkPostNotExist(String title) {
        Assert.assertEquals("post '" + title + "' exist!!!", 0, getPostsListWithTitle(title).size());
        return this;
    }

    private List<WebElement> getPostsListWithTitle(String title) {
        return webDriver.findElements(By.xpath(String.format(locatorListPostsWithTitle, title)));
    }
}
