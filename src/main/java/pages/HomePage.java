package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage{

    public HeaderElement headerElement=new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }



}
