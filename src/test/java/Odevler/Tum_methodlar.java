package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;

public class Tum_methodlar extends TestBase {
    @Test
    public void name() throws InterruptedException {

        //1.https://www.trendyol.com/ sayfasına gidin.
        driver.navigate().to("https://www.trendyol.com/");

       Thread.sleep(3000);

        //*[text()='Giriş Yap'][1]
        //*[@id='login-email']
        //*[@id='Combined-Shape']
        //*[@id='onetrust-accept-btn-handler']
        //*[@id='onetrust-accept-btn-handler']
        //ekrana gelen kadın erkek seçimin kapata bas.

        driver.findElement(By.xpath(" //*[@id='Combined-Shape']")).click();
        //cerezleri kabul et.
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        //alerti kabul etme
        //driver.switchTo().alert().accept();
        //2.signin butonuna tıklayın
         driver.findElement(By.xpath("//*[text()='Giriş Yap'][1]")).click();
        //3.login alanına "esratepecik58@gmail.com" yazdırın
        // isim kutusunu locate edip,
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        WebElement email=driver.findElement(By.xpath("//*[@id='login-email']"));
        Actions actions=new Actions(driver);
        //4.Password alanına "password" yazdırın
        actions.click(email).sendKeys("esratepecik58@gmail.com").sendKeys(Keys.TAB).sendKeys("1622esra").perform();


        //5.Sign in buttonuna tıklayın
        //*[@class='q-primary q-fluid q-button-medium q-button submit']
        driver.findElement(By.xpath("//*[@class='q-primary q-fluid q-button-medium q-button submit']")).submit();

        //">" işaretine iki kez tıkla
        //*[@class='i-arrow-right']
       //WebElement button= driver.findElement(By.xpath("//*[@class='i-arrow-right']"));
       //button.click();
        //7.amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın.

        //8.tarih kısmına"2020.09.10" yazin

        //9.Pay buttonuna basın.

        //10."The payment was successfuly submitted"mesajının çıktığını kontrol et.
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        //-Cookies’i kabul edin
        //-“Create an Account” button’una basin
        //-“radio buttons” elementlerini locate edinWebElement erkekElementi=driver.findElement(By.xpath("//input[@value='2']"));WebElement ozelElementi=driver.findElement(By.xpath("//input[@value='-1']"));
        //-Secili degilse cinsiyet butonundan size uygun olani secin
        //url 'in  "amazon" icerdiğini test edin
        // dropdowndan books seceneğini seçmel seçip icin 3 adım vardır
        // 1. adım locate edilirddm.click();
        // 2 bir Select objesi oluşurmakselect.selectByIndex(5);
        // 3. dropdownda var olan optinallardan istedğimiz bir taneyi secelim adım optional
        //select.selectByIndex(5);// ındex le secer
        // select.selectByValue("search-alias=stripbooks-intl-ship");// value secer
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
        // bunun uzerine HTML kodlari inceleyince
        // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // bu durumda once iframe'i locate edip
        // switchTo() ile o iFrame'e gecmeliyiz
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        /*
        CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecemek istiyorsak
        driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
           /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        // 4- yeni tab'da acilan urunun title'ini yazdirin
        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim

        // 4- title'in Best Buy icerdigini test edelimString arananKelime="Best Buy";
        // 5- ilk sayfaya donup sayfada java aratalim
        // 6- arama sonuclarinin Java icerdigini test edelim
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        // 8- logonun gorundugunu test edelim
       // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        // once arama kutusuna click yapip
        // sonra harf harf Nutella yazisini yazdiralim
        // sonra da ENTER tusuna basalim
        //hesabım menüsünden çıkış yap
        //*[text()='Hesabım']
        //*[text()='Çıkış Yap']
        actions.moveToElement(driver.findElement(By.xpath("  //*[text()='Hesabım']")));
        driver.findElement(By.xpath("//*[text()='Çıkış Yap']"));
    }
}