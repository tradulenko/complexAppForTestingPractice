package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPage {

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@data-icon='edit']")
    private WebElement editButton;

    @Override
    String getRelativeUrl() {
        return "/post/.*";
    }

    public PostPage checkRedirectToPostPage() {
        checkUrlWithPattern();
        Assert.assertTrue(editButton.isDisplayed());
        return this;
    }
}
