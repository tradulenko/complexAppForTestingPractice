package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPage {
    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }

    @FindBy(xpath = ".//*[@id='post-title']")
    private WebElement postTitle;

    @FindBy(xpath = ".//*[@id='post-body']")
    private WebElement textAreaPostBody;

    @FindBy(xpath = ".//button[contains(text(),'Save')]")
    private WebElement savePostButton;

    public CreatePostPage fillInPostTitle(String title) {
        enterTextIntoElement(postTitle, title);
        return this;
    }

    public CreatePostPage fillInPostBody(String body) {
        enterTextIntoElement(textAreaPostBody, body);
        return this;
    }

    public PostPage savePost() {
        clickOnElement(savePostButton);
        return new PostPage(webDriver);
    }
}
