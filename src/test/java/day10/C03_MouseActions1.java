package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1

    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan=driver.findElement(By.xpath("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedyazi= "You selected a context menu";
        String actualyazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedyazi,actualyazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilksayfaWHDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleseti=driver.getWindowHandles();
        String ikinciSayfaWH="";
        for (String each:handleseti
             ) {
            if (!each.equals(handleseti)){
                ikinciSayfaWH=each;
            }
                driver.switchTo().window(ikinciSayfaWH);
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        //- https://www.lcwaikiki.com/tr-TR/TR sitesi açılır.
        //- Ana sayfanın açıldığı kontrol edilir. Siteye login olunurWebElement anasayfaBaslık=driver.findElement(By.xpath("//a[@class='main-header-logo']"));
        //- Login işlemi kontrol edilir.
        //- Arama kutucuğuna “pantolan” kelimesi girilir.
        //- Sayfanın sonuna scroll edilir.
        //- “Daha fazla ürün gör “ butonuna tıklanır.
        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        //- Seçilen ürün sepete eklenir.
        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
    }
}