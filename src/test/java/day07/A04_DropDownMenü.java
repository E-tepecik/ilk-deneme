package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A04_DropDownMenü {
    /*
   amazona git
   dropdowndan books seceneğini seçip
   java aratalım
   ve arama sonuclarının
   java icerdiğini test edelim
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public  void test1() {
        //1.) amazona git
        driver.get("https://www.amazon.com/");
        // dropdowndan books seceneğini seçmel seçip icin 3 adım vardır
        // 1. adım locate edilir
       WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
       ddm.click();
        // 2 bir Select objesi oluşurmak
        Select select=new Select(ddm);
        select.selectByIndex(5);
        // 3. dropdownda var olan optinallardan istedğimiz bir taneyi secelim adım optional
        //select.selectByIndex(5);// ındex le secer
        // select.selectByValue("search-alias=stripbooks-intl-ship");// value secer
        // 3.)java aratalım
        WebElement search= driver.findElement(By.xpath("//*[@type='text']"));
        search.sendKeys("java"+Keys.ENTER);
        //    ve arama sonuclarının

        //    java icerdiğini test edelim

    }
}