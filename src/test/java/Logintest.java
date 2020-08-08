

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


public class Logintest {

    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
driver.get("https://rozetka.com.ua/");

System.out.println(driver.getTitle());
driver.close();
    }


}
