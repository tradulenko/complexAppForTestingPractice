package pages;

import org.openqa.selenium.WebDriver;

public class PostPage extends ParentPage {

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
