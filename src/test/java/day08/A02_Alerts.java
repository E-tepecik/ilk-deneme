package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A02_Alerts {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }


    @Test
    public void test1() {
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      "You successfully clicked an alert" oldugunu test edin.
       driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
       String expectedresult="You successfully clicked an alert";
        WebElement actualReseult = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        Assert.assertEquals(expectedresult,actualReseult);
    }

    @AfterClass
    public static void bitis() {
     //driver.close();


    }

}
