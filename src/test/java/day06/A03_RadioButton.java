package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A03_RadioButton {
WebDriver driver;
    //1.bir class oluşturun
    //2.gereki yapıyı oluşturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public  void  tearDown(){
        driver.close();
    }
    @Test
    public void test01 () throws InterruptedException {
        //3.https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        WebElement kadın=driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement erkek=driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement ozel= driver.findElement(By.xpath("//*[text()='Özel']"));

        if (!kadın.isSelected()){
            kadın.click();
        }
        Thread.sleep(5000);
    }

    //4.Cookies'i kabul edin
    //5.radio buttons elementlerini locate edin,
    //6.Seçili değilse cinsiyet buttonunda size uygun olanı seçin

}
