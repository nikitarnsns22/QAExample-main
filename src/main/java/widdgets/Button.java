package widdgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button {

    WebElement button;

    public Button(WebElement element) {
        button = element;
    }


    public void click() {
        button.click();
    }

    public String getText() {
        return button.getText();
    }

    public void doubleClick() {
        button.click();
        button.click();
    }

}
