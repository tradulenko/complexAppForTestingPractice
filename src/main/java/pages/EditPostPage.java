package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class EditPostPage extends ParentPage {
    @FindBy(id = "post-title")
    private WebElement editTitle;
    @FindBy(id = "post-body")
    private WebElement editBody;
    @FindBy(xpath = ".//button[@class='btn btn-primary']")
    private WebElement buttonSaveUpdates;
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement textMessageOnEdit;
    HeaderElement headerElement = new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/post/.*/edit";
    }


    public EditPostPage checkToRedirectToEditePostPage() {
        checkUrlWithPattern();
        Assert.assertTrue("EditPostPage doesn't loaded", isElementDisplayed(editTitle));
        Assert.assertTrue("EditPostPage doesn't loaded", isElementDisplayed(editBody));
        return this;
    }

    public EditPostPage enterNewTextTitleInEdit(String newTitle) {
        waitChatToBeHide();
        logger.info("OLD Title is '" + editTitle.getAttribute("value") + "'");
        enterTextIntoElement(editTitle, newTitle);
        return this;
    }

    public EditPostPage clickOnSaveUpdates() {
        clickOnElement(buttonSaveUpdates);
        waitChatToBeHide();
        return this;
    }

    public EditPostPage checkTextMessageAfterEdit(String message) {
        waitChatToBeHide();
        Assert.assertEquals("Wrong text message after click on Edit post", message, textMessageOnEdit.getText());
        return this;
    }
}
