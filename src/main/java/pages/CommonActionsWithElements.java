package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import libs.properties_files.PropertiesFilesProvider;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWaitLow, webDriverWaitHigh;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

        webDriverWaitLow = new WebDriverWait(webDriver,
                Duration.ofSeconds(PropertiesFilesProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWaitHigh = new WebDriverWait(webDriver,
                Duration.ofSeconds(PropertiesFilesProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "' was inputted into '" + getElementName(webElement) + "'");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWaitHigh.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info("'" + name + "' was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(String xpathLocator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(xpathLocator));
            clickOnElement(element);

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            String message;
            if (state) {
                message = "Element is displayed";
            } else {
                message = "Element is not displayed";
            }
            logger.info(message);
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }

    }

    /**
     * Choosing value in the dropdown using visible text
     *
     * @param dropDown
     * @param text
     */
    protected void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info("'" + text + "' was selected in DropDown");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    /**
     * Choosing value in the dropdown
     *
     * @param dropDown
     * @param value
     */
    protected void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info("'" + value + "' was selected in DropDown");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * @param checkbox
     * @param neededValue (Only can be "check" or "uncheck")
     */
    protected void selectCheckBoxValue(WebElement checkbox, String neededValue) {
        boolean isNeededStateCheck = neededValue.equalsIgnoreCase("check");
        boolean isNeededStateUnCheck = neededValue.equalsIgnoreCase("uncheck");
        boolean isCheckBoxSelected = checkbox.isSelected();
        if (isNeededStateCheck || isNeededStateUnCheck) {
            if ((isCheckBoxSelected && isNeededStateCheck) ||
                    (!isCheckBoxSelected && isNeededStateUnCheck)) {
                logger.info("Check box value is as needed");
            } else {
                checkbox.click();
                logger.info("Checkbox value is changed");
            }
        } else {
            logger.error("Invalid values, can be only \"check\" or \"uncheck\"");
            Assert.fail("Invalid values, can be only \"check\" or \"uncheck\"");
        }

    }

    public void userOpensNewTab() {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }

    public void scrollToElement(WebElement buttonSaveUpdates) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(buttonSaveUpdates);
        actions.perform();
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }

    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }


}

