package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A01_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1.http://zero.webappsecurity.com sayfasına gidin.
        driver.get("http://zero.webappsecurity.com");
        //2.signin butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3.login alanına "username" yazdırın
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4.Password alanına "password" yazdırın
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5.Sign in buttonuna tıklayın
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        //6.Pay Bills sayfasına gidin
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("20");
        //8.tarih kısmına"2020.09.10" yazin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020.09.10");
        //9.Pay buttonuna basın.
        driver.findElement(By.id("pay_saved_payees")).click();
        //10."The payment was successfuly submitted"mesajının çıktığını kontrol et.
        WebElement sonucYazısı=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (sonucYazısı.isDisplayed()) {
            System.out.println("test passed");
        }else System.out.println("test failed");

    }
}
