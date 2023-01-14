package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = ".//button[contains(text(),'Sign Out')]")
    private WebElement signOutButton;


    @Override
    String getRelativeUrl() {
        return "/";
    }


    public HomePage checkRedirectToHomePage() {
        checkUrl();
        Assert.assertTrue("Home page is not opened", isElementDisplayed(signOutButton));
        Assert.assertTrue("Create Button is not displayed", getHeaderElement().isCreatePostButtonDisplayed());
        return this;
    }

    public HomePage checkRedirectToHomePageAfterRegistration(String text, String profileNameExpected) {
        Assert.assertTrue("Welcome message is not displayed", text.matches(text));
        Assert.assertTrue("Profile name is not matching", getHeaderElement().displayedProfileName().matches(profileNameExpected));
        Assert.assertTrue("Search wizard is not displayed", getHeaderElement().isSearchWizardDisplayed());
        Assert.assertTrue("Comment Icon is not displayed", getHeaderElement().isCommentIconDisplayed());
        Assert.assertTrue("Avatar Icon is not displayed", getHeaderElement().isAvatarIconDisplayed());
        return this;
    }
}
