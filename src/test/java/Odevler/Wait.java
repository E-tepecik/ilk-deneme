package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Wait extends TestBase {

    // 1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    @Test
    public void implicitWait() {
        //1. Bir class olusturun : WaitTest

        //2. Iki tane metod olusturun : implicitWait() , explicitWait()

        //Iki metod icin de asagidaki adimlari test edin.

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();


        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.

         WebElement yazi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
         Assert.assertTrue(yazi.isDisplayed());

        //6. Add buttonuna basin
         driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        //7. It's back mesajinin gorundugunu test edin
    WebElement yazi2  =  driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
    Assert.assertTrue(yazi2.isDisplayed());
    }
    @Test
    public void explicitWait1 (){
        //1. Bir class olusturun : WaitTest

        //2. Iki tane metod olusturun : implicitWait() , explicitWait()

        //Iki metod icin de asagidaki adimlari test edin.

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.
      WebElement mesaj1=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@id='message'])[1]")));
      Assert.assertTrue(mesaj1.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It's back mesajinin gorundugunu test edin
        WebElement mesaj2=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='message'])[1]")));
        Assert.assertTrue(mesaj2.isDisplayed());
    }
}