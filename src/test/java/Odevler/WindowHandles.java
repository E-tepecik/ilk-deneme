package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandles extends TestBase {
    @Test
    public void setup() throws InterruptedException {
        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedttext="Opening a new window";
        WebElement actualtext=driver.findElement(By.xpath("//h3"));
        String actualtext1=actualtext.getText();
        Assert.assertEquals(expectedttext,actualtext1);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
       String actualTitle=driver.getTitle();
       String expectedTitle="The Internet";
       Assert.assertEquals(expectedTitle,actualTitle);
    /*
    eger kontrolsuz acilan bir tab veya window varsa
    o zaman sayfalarin window handle degerlerini elde etmem gerekir.
    oncelikle 2.sayfa acilmadan once
    ilk sayfanin window handle degerini bir String'e atayalim
     */
       String ilksayfaWHdegeri= driver.getWindowHandle();
       WebElement clickHere=driver.findElement(By.xpath("//*[text()='Click Here']"));
       clickHere.click();

       Set<String > handeles=driver.getWindowHandles();
        String ikinciSayfaWH="";
        for (String each:handeles
             ) {
            if (!each.equals(ilksayfaWHdegeri)){
                ikinciSayfaWH=each;
            }
        }
        System.out.println(ikinciSayfaWH);
        Thread.sleep(5000);
       driver.switchTo().window(ikinciSayfaWH);
    /*
      switchTo().newWindow() demeden link tiklayarak yeni tab veya wiw oluştuğunda biz
      biz driver'a yeni sayfaya gec demedikce, driver eski sayfada ka
      ve yeni sayfa ile ilgili hicbir islem yapamaz
      yeni sayfada driver'i calistirmak isterseniz
      once driver'i yeni sayfaya yollamalisiniz
        */
   /*
   yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegerini almamız lazım
   bunun icin driver.getWindowHandles() method'unu kullanarak
   acik olan tum sayfalarin window handle degerlerini alip bir set'e
   ilk sayfanin window handle degerini zaten biliyoruz
   Set'deki window handle degerlerini kontrol edip
   ilk sayfanin handle degerine esit olmayan
   ikinci sayfanin woindow handle degeridir deriz
    */

        // artik ikinci sayfanin window handle degerini biliyoruz


        // rahatlikla sayfalar arasii gecis yapabiliriz
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window”
          String actual=driver.getTitle();
          String expected="New Window";
          Assert.assertEquals(expected,actual);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        Thread.sleep(5000);
        driver.switchTo().window(ilksayfaWHdegeri);
        // “The Internet” olduğunu doğrulayın.
        System.out.println(driver.getTitle());

    }

}
