package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTable extends TestBase {
    @Test
    public void name() {


        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!
        girisYap();
        //● table( ) metodu oluşturun
        //          ○ Tüm table body'sinin boyutunu(sutun sayisi) bulun. /tbody
        driver.findElements(By.xpath("//thead//tr[1]//th"));

        //          ○ Table'daki tum body'I ve başlıkları(headers) konsolda yazdırın.
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        //● printRows( ) metodu oluşturun //tr
        //          ○ table body'sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarListesi.size());
        //          ○ Table body'sinde bulunan satirlari(rows) konsolda yazdırın.

        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
    }

    private void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}