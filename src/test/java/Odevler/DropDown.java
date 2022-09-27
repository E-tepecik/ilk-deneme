package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class DropDown extends TestBase {
     /*
    1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna "username" yazin
4. Password kutusuna "password." yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. "Purchase Foreign Currency" tusuna basin
8. "Currency" drop down menusunden Eurozone'u secin
9. "amount" kutusuna bir sayi girin
10. "US Dollars" in secilmedigini test edin
11. "Selected currency" butonunu secin
12. "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
13. "Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin
     */
    @Test
    public void test(){
     driver.get("http://zero.webappsecurity.com/");
     WebElement sigİn=driver.findElement(By.xpath("//*[@id='signin_button']"));
     sigİn.click();
     WebElement logİn=driver.findElement(By.xpath("//*[@id='user_login']"));
     logİn.sendKeys("username");
     WebElement pasword=driver.findElement(By.xpath("//*[@id='user_password']"));
     pasword.sendKeys("password");
     driver.findElement(By.xpath("//*[@name='submit']")).click();
     driver.navigate().back();
     driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
     driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
     driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
     WebElement ddm=driver.findElement(By.xpath("//*[@id='pc_currency']"));
     Select options=new Select(ddm);
     options.selectByIndex(6);

     driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("8");

     WebElement button=driver.findElement(By.id("pc_inDollars_true"));
     Assert.assertFalse(button.isSelected());
     WebElement buttonSec= driver.findElement(By.xpath("//*[@id='pc_inDollars_false']"));
     buttonSec.click();

     driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();

     driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();
     WebElement yazi=driver.findElement(By.xpath("//*[@id='alert_content']"));
     Assert.assertTrue(yazi.isDisplayed());
    }
}
