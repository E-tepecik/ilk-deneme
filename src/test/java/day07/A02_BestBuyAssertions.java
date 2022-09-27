package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A02_BestBuyAssertions {
    //2.https://www.bestbuy.com/ adresine gidin
    //3.farklı test metodları oluşturarak aşağıdaki testleri yapın
    //4.sayfa url'inin https://www.bestbuy.com/ eşit olduğunu tespit edin
    //5.titleTest=>sayfa başlığını rest içermediğini test edin
    //6.logoTest=>BestBuy logosunun görüntülendiğini test edin
    //7.francaisLinkTest=>Fransizca Linkin göründüğünü test edin

   static WebDriver driver;

    @BeforeClass
    public static void seTup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @AfterClass
    public static void tearDown() {
       driver.close();

    }

    @Test
    public void test1() {
        driver.get("https://www.bestbuy.com/");
        String expectedURL="https://www.bestbuy.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("eşit mi",expectedURL,actualURL);
    }
    @Test
    public void test2() {

        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3() {

        String expectedLogo="BestBuy";
        WebElement actualLogo=driver.findElement(By.xpath("//*[@class='logo']"));
        Assert.assertTrue(actualLogo.isDisplayed());
    }
    @Test
    public void test4() {

        WebElement actualTitle=driver.findElement(By.xpath("//*[@lang='fr']"));
        Assert.assertTrue(actualTitle.isDisplayed());
    }
}
