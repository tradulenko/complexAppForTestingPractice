package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.CreatePostPage;
import pages.LoginPage;
import pages.MyProfilePage;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy(xpath = ".//button[@class='btn btn-sm btn-secondary']")
    private WebElement buttonSignOut;
    @FindBy(xpath = ".//*[@alt='My profile']")
    private WebElement avatarIcon;
    @FindBy(xpath = ".//*[@data-icon='comment']")
    private WebElement commentIcon;
    @FindBy(xpath = ".//*[@data-icon='search']")
    private WebElement searchWizard;
    @FindBy(xpath = ".//span[@class='text-white mr-2']")
    private WebElement profileName;
    @FindBy(xpath = ".//*[@href='/create-post']")
    private WebElement createPostButton;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonSignOutDisplayed() {
        return isElementDisplayed(buttonSignOut);
    }

    public MyProfilePage clickOnAvatarIcon() {
        clickOnElement(avatarIcon);
        return new MyProfilePage(webDriver);
    }

    public LoginPage clickOnSignOutButton() {
        clickOnElement(buttonSignOut);
        return new LoginPage(webDriver);
    }

    public boolean isAvatarIconDisplayed() {
        return isElementDisplayed(avatarIcon);
    }

    public String displayedProfileName() {
        return profileName.getText();
    }

    public boolean isSearchWizardDisplayed() {
        return isElementDisplayed(searchWizard);
    }

    public boolean isCommentIconDisplayed() {
        return isElementDisplayed(commentIcon);
    }

    public boolean isCreatePostButtonDisplayed() {
        return isElementDisplayed(createPostButton);
    }

    public CreatePostPage clickOnCreatePostButton() {
        clickOnElement(createPostButton);
        return new CreatePostPage(webDriver);
    }

}
