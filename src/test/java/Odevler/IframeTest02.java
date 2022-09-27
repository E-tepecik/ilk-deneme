package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeTest02 extends TestBase {
    //●Bir class olusturun:IframeTest02
    //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
    @Test
    public void test1() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> iframesayisi = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframesayisi.size());
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        driver.switchTo().defaultContent();
        WebElement iframeiki = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframeiki);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        driver.switchTo().defaultContent();

        //2)sayfadaki iframe sayısınıbulunuz.

        //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
        //4)ilk iframe'den çıkıp ana sayfayadönünüz
        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
    }
}