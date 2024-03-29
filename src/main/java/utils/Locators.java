package utils;

import org.openqa.selenium.By;

public interface Locators {

    public interface MainPage{

        By JAVA_BUTTON = By.xpath("//*[@class='navmenu']/a[5]");

    }

    public interface JavaPage{
        By  JAVA_EE_BUTTON = By.xpath("//*[@class='navmenu']/a[3]");
    }

    //Оптимизировать xpath!!!
    public interface JavaEEPage{
        By ABOUT_JAVA_EE_BUTTON = By.xpath("/html/body/div[@id='container']/div[@class='outercontainer']/div[@class='innercontainer']/div[@class='item center menC']/ol[@class='content']/li[1]/ol[@class='subsubcontent']/li/p/a");
        By TEXT_ABOUT_JAVA = By.xpath("/html/body/div[@id='container']/div[@class='outercontainer']/div[@class='innercontainer']/div[@class='item center menC']/p[1]");
        By TEXT_ABOUT_JAVA_SERVLETS = By.xpath("/html/body/div[@id='container']/div[@class='outercontainer']/div[@class='innercontainer']/div[@class='item center menC']/ul/li[1]/p");
    }

}
