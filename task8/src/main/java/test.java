import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class test {
    WebDriver driver;

    By firstElement= By.xpath("//*[@class='goods-tile__heading ng-star-inserted']");
    By buttonBuy=By.xpath("//*[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']");
    By makeOrderButton=By.xpath("//*[@class='button button_size_large button_color_green cart-receipt__submit ng-star-inserted']");

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "browserdriver/chromedriver.exe");
    }

    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");


    }
    @Test
    public void test() {

        WebDriverWait wait = new WebDriverWait(driver, 4);
        Actions actions = new Actions(driver);
        WebElement searchElement = driver.findElement(By.xpath("//input[@name='search']"));
        searchElement.clear();
        searchElement.sendKeys("Монитор");

        WebElement searchButton = driver.findElement(By.cssSelector(".button.search-form__submit"));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstElement));
        WebElement firstProductElement = driver.findElement(firstElement);
        firstProductElement.click();

        WebElement searchElementBait = driver.findElement(By.xpath("//input[@name='search']"));
        actions.moveToElement(searchElementBait).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBuy));
        WebElement buttonBuyClick = driver.findElement(buttonBuy);
        actions.moveToElement(buttonBuyClick).perform();
        buttonBuyClick.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        WebElement orderButtonClick = driver.findElement(makeOrderButton);
        actions.moveToElement(orderButtonClick).perform();
        orderButtonClick.click();


    }
}