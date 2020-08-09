import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Logintest {
    private final String SearchField = "//*[@name='search']";
    private final String SearchButton = "//*[@class='button button_color_green button_size_medium search-form__submit']";
    private final String BuyButton = "//*[@data-goods-id='234428251']//*[@class='buy-button goods-tile__buy-button']";
    private final String OpenBasket = "//*[@class='header-actions__button header-actions__button_type_basket header-actions__button_state_active']";
    private final String QuantityUp = "//*[@aria-label='Добавить ещё один товар']";
    private final String OrderHookan = "//*[@class='button button_size_large button_color_green cart-receipt__submit']";
    private final String InputSurname = "//*[contains(@class, 'form__row js-surname')]/input";
    private final String InputName = "//*[contains(@class, 'form__row js-name')]/input";
    private final String InputPhone = "//*[contains(@class, 'form__row js-phone')]/input";
    private final String WaitSearchProduct = "//*[@class='search-suggest']";
    private final String WaitLoadHookan = "//*[@data-goods-id='234428251']";
// wait to load page
    private final String WaitLoadBasket = OpenBasket;
    private final String WaitQuantityUp = QuantityUp;
    private final String WaitOrderHookan = OrderHookan;
    private final String WaitAuthorizationPage = InputSurname;
    WebDriver driver = new ChromeDriver();
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 20).withMessage("Element was not found");

    @AfterMethod
    private void close() {
        driver.close();
    }

    @BeforeSuite
    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void rozetkaHookan() {

        driver.get("https://rozetka.com.ua/");

        sendKeys(SearchField, "hookan");

        waitElement(WaitSearchProduct);

        Assert.assertTrue(driver.getTitle().contains("ROZETKA"), "Title is Rozetka");

        click(SearchButton);

        waitElement(WaitLoadHookan);

        click(BuyButton);

        waitElement(WaitLoadBasket);

        click(OpenBasket);

        waitElement(WaitQuantityUp);

        click(QuantityUp);

        waitElement(WaitOrderHookan);

        click(OrderHookan);

        waitElement(WaitAuthorizationPage);

        sendKeys(InputSurname, "Коев");

        sendKeys(InputName, "Олег");

        sendKeys(InputPhone, "0939558108");


    }


    private void waitElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    private void sendKeys(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
}
