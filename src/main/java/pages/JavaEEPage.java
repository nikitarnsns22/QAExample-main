package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class JavaEEPage {

    private WebDriver browser;

    public JavaEEPage(WebDriver browser) {
        this.browser = browser;
    }

    public JavaEEPage() {
    }

    public JavaEEPage clickAboutJavaEEButton() {
        WebElement aboutJavaEEButton = browser.findElement(Locators.JavaEEPage.ABOUT_JAVA_EE_BUTTON);
        aboutJavaEEButton.click();
        return this;
    }

    public String getDescriptionJavaEE() {
        WebElement textAboutJava = browser.findElement(Locators.JavaEEPage.TEXT_ABOUT_JAVA);
        return textAboutJava.getText();
    }

    public String getDescriptionJavaServlets() {
        WebElement textAboutJava = browser.findElement(Locators.JavaEEPage.TEXT_ABOUT_JAVA_SERVLETS);
        return textAboutJava.getText();
    }

}
