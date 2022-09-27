package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Wait2 extends TestBase {
    @Test
    public void waitmethodu() {
            // 1. Bir class olusturun : EnableTest
            //2. Bir metod olusturun : isEnabled()
            //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
              driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            //4. Textbox'in etkin olmadigini(enabled) dogrulayın
        WebElement textbox=driver.findElement(By.xpath("//*[text()='It's disabled!']"));
            //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='It's enabled!']")));
        driver.findElement(By.xpath("//*[text()='It's enabled!']"));
            //6. "It's enabled!" mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(masage.isDisplayed());
            //7. Textbox'in etkin oldugunu(enabled) dogrulayın.











        }
}
