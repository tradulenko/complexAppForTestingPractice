package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.containsString;
import static pages.PropertiesProvider.configPropertiesHidden;

abstract class ParentPage extends CommonActionsWithElements {
    protected String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        if (!configPropertiesHidden.BASE_URL().isEmpty()) {
            baseUrl = "https://" + System.getProperty("env", "qa") + "-" + System.getProperty("url", configPropertiesHidden.BASE_URL());
        } else {
            logger.info("add params to the command line or load HiddenConfig");
            Assert.fail("add params to the command line or load HiddenConfig");
        }
    }

    abstract String getRelativeUrl();

    protected void checkUrl() {

        Assert.assertEquals(
                "Invalid Page",
                baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern() {
        String actualURL = webDriver.getCurrentUrl();
        Assert.assertTrue("\n ActualURL " + actualURL + "\n "
                        + "ExpectedURL pattern" + baseUrl + getRelativeUrl() + " \n "
                , actualURL.matches(baseUrl + getRelativeUrl()));
    }

    protected void waitChatToBeHide() {
        webDriverWaitLow.withMessage("Chat is not closed")
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath(".//*[@id='chat-wrapper']")));
    }
}

