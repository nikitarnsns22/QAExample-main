package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;
import widdgets.Button;

public class MainPage {

    private WebDriver browser;
    Button javaButton;

    public MainPage(WebDriver browser) {
        this.browser = browser;
        this.javaButton = new Button(browser.findElement(Locators.MainPage.JAVA_BUTTON));
    }

    public JavaPage clickJavaButton() {
       javaButton.click();
        return new JavaPage(browser);
    }

}
