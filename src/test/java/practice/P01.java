package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBase {
    @Test
    public void test() {

        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        for (WebElement w : animals
        ) {
            w.click();
        }

        driver.switchTo().defaultContent();
        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> boxes=driver.findElements(By.xpath("//*[@class='mdl-textfield__input']"));
        List <String> text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelementi","kolayca","boxes","liste","ekleyebileceğiz","fhsagd"));
        //bu listi kullanaraka her bir weelementi kolayca boxses listinde buunan webelementine gönderebileceğiz.

        for (int i = 0; i <boxes.size() ; i++) {
            boxes.get(i).sendKeys(text.get(i));
        }
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // apply butonuna tıklayınız.git
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}