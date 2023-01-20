package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy(xpath = ".//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement createPostButton;
    @FindBy(xpath = ".//button[@class='btn btn-sm btn-secondary']")
    private WebElement buttonSignOut;
    @FindBy(xpath = ".//a[@class='mr-2']")
    private WebElement buttonMyPrifile;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonSignOutDisplayed() {
        return isElementDisplayed(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(createPostButton);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfile() {
        clickOnElement(buttonMyPrifile);
        return new MyProfilePage(webDriver);
    }
}
