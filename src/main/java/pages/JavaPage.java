package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class JavaPage {

    private WebDriver browser;

    public JavaPage(WebDriver browser) {
        this.browser = browser;
    }

    public JavaEEPage clickJavaEEButton() {
        WebElement javaEEButton = browser.findElement(Locators.JavaPage.JAVA_EE_BUTTON);
        javaEEButton.click();
        return new JavaEEPage(browser);
    }

}
