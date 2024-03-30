

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoffeeShopTest {
    private WebDriver driver;

    @Before
    public void pc() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //     ТЕСТ 1. Поиск по сайту
    @Test
    public void checkSearch()  {
        //1) Открыть главную страницу сайта
        driver.get("https://majaro.ru");
        //2) Нажать на кнопку «поиск».
        WebElement searchButton = driver.findElement(By.xpath("(//i[contains(@class,'icon search')])[2]"));
        searchButton.click();
        //3) Ввести наименование товара в поле поиска
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div[1]/a/form/span/input[1]"));
        searchBox.sendKeys("Арабика");
        // 4) Нажать на кнопку с изображением лупы
        WebElement searchButton_1 = driver.findElement(By.xpath("(//input[@class='icon search'])[2]"));
        searchButton_1.click();
        //Проверка: URL открывшейся страницы содержит в себе закодированное значение введенного наименования
        // 1) Получение текущего URL
        String currentUrl = driver.getCurrentUrl();
        // Проверка, содержит ли URL поисковый запрос
        Assert.assertTrue(currentUrl.contains("%D0%90%D1%80%D0%B0%D0%B1%D0%B8%D0%BA%D0%B0"));
    }
    //    ТЕСТ 2. Добавление товара в корзину
    @Test()
    public void checkAddInCart() throws InterruptedException {
        // 1. Открыть главную страницу сайта
        driver.get("https://majaro.ru");
        // Прокрутка страницы вниз на 1300 пикселей для получения видимости товара
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1300)");
        // 2. Добавить в корзину первый товар
        WebElement addProduct = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div[5]/div/div[8]/form/div[3]/div[2]/button/span/i"));
        addProduct.click();
        // Задержка для загрузки добавления товара 0.3 сек
        Thread.sleep(300);
        // Получить ID первого товара из открывшегося раздела
        WebElement product = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div[5]/div/div[8]/form/input"));
        String expectedProductId = product.getAttribute("value");
        // 3. Перейти в корзину
        WebElement openCart = driver.findElement(By.xpath("//div[@class='h-mid-cart']//i[1]"));
        openCart.click();
        //Проверка: ID выбранного товара соответствует ID товара в корзине
        WebElement productInCart = driver.findElement(By.xpath("(//div[@class='c-item'])[1]"));
        String actualProductId = productInCart.getAttribute("data-product-id");
        Assert.assertEquals(expectedProductId, actualProductId);
    }
    // ТЕСТ 3. Сортировка товаров на странице
    @Test()
    public void checkSort() {
        // 1. Открыть главную страницу сайта
        driver.get("https://majaro.ru");
        // Прокрутка страницы вниз на 1800 пикселей для получения видимости кнопки «Смотреть все товары»
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1800)");
        // 2. Перейти на вкладку «Смотреть все товары»
        WebElement teaSection = driver.findElement(By.xpath("//a[contains(text(),'Смотреть все товары →')]"));
        teaSection.click();
        // 3. Отсортировать
        WebElement typeOfTeaFilter = driver.findElement(By.id("c_sorting_select"));
        typeOfTeaFilter.click();
        WebElement typeOfTeaFilter1 = driver.findElement(By.xpath("(//option[@value='price'])[2]"));
        typeOfTeaFilter1.click();
        //Проверка: URL открывшейся страницы содержит в себе запрос на сортировку
        // 1) Получение текущего URL
        String currentUrl = driver.getCurrentUrl();
        // Проверка, содержит ли URL поисковый запрос
        Assert.assertTrue(currentUrl.contains("sort=price&order=desc"));
    }
    // ТЕСТ 4. Просмотр акций на сайте
    @Test()
    public void checkStock()  {
        // 1. Открыть главную страницу сайта.
        driver.get("https://majaro.ru");
        // 2. Перейти в раздел «Акции»
        WebElement readSection = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/ul/li[4]/a"));
        readSection.click();
        //Получить название 1 акции в списки
        WebElement articleName = driver.findElement(By.xpath("(//h2[@class='post-cpt'])[1]"));
        String expectedArticle = articleName.getText();
        // 3. Нажать кнопку «Читать далее» 1 акции
        WebElement goToArticle = driver.findElement(By.xpath("(//a[@class='post-link inl'])[1]"));
        goToArticle.click();
        // Получить название выбранной акции
        WebElement article = driver.findElement(By.xpath("//span[@class='category-name']//h1[1]"));
        String actualArticle = article.getText();
        //Проверка: Название открывшейся акции соответствует названию выбранной акции
        Assert.assertEquals(expectedArticle, actualArticle);
    }
    //     ТЕСТ 5. Добавление товара в избранное
    @Test()
    public void checkFavorites() throws InterruptedException {
        // 1. Открыть главную страницу сайта
        driver.get("https://majaro.ru");
        // Прокрутка страницы вниз на 1000 пикселей для получения видимости товара
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        // 2. Добавить в избранное первый товар
        WebElement addProduct = driver.findElement(By.xpath("(//div[@data-position='1'])[1]/div/div[1]/i"));
        addProduct.click();
        // Получить ID первого товара
        WebElement product = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div[5]/div/div[8]/form/input"));
        String expectedProductId = product.getAttribute("value");
        // 3. Перейти в избранное
        WebElement openCart = driver.findElement(By.xpath("//a[@title='Избранные товары']//i[1]"));
        openCart.click();
        //Проверка: ID добавленного товара соответствует ID товара в избранном
        // Получить ID товара в избранном
        WebElement productInFavourite = driver.findElement(By.xpath("//div[@class='t-product p-ecomm']"));
        String actualProductId = productInFavourite.getAttribute("data-id");
        Assert.assertEquals(expectedProductId, actualProductId);
    }

    @After
    public void close() {
        driver.close();
    }

}