package Odevler;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeybordActions extends TestBase {
    @Test
    public void test01() {

        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        // driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String fake=faker.internet().password();
        actions.click(isimKutusu)
                .sendKeys("Esra")
                .sendKeys(Keys.TAB)
                .sendKeys("tepecik")
                .sendKeys(Keys.TAB)
                .sendKeys("5340592656")
                .sendKeys(Keys.TAB)
                .sendKeys(fake)
                .perform();




    }
}
