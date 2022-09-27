package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A02_HandleWindows {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String İlkSayfaHandleDegeri=driver.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        String istenenKelime = "amazon";
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains(istenenKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandleDegeri=driver.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        String expectedTitle="Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5- ilk sayfaya donup sayfada java aratalim
         driver.switchTo().window(İlkSayfaHandleDegeri);
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+Keys.ENTER);
         //6-arama sonuçlarının java içerdiğini test edin
        WebElement sonucyazısı=driver.findElement(By.className("a-color-state a-text-bold"));
        String actualSonuc=sonucyazısı.getText();
        String istenenSonuc="java";
        Assert.assertTrue(actualSonuc.contains(istenenSonuc));
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
          driver.switchTo().window(ikinciSayfaHandleDegeri);
        // 8- logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        Thread.sleep(3000);
    }
}
