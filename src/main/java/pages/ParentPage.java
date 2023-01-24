package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import libs.global_parameters.GlobalParametersProvider;

abstract class ParentPage extends CommonActionsWithElements {
    protected String baseUrl;

    protected ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = GlobalParametersProvider.getFullBaseUrl();
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

    protected void waitChatToBeHidden() {
        webDriverWaitLow.withMessage("Chat is not closed")
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath(".//*[@id='chat-wrapper']")));
    }
}

