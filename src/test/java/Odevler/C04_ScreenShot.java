package Odevler;

import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

public class C04_ScreenShot extends TestBase {
    @Test
    public void name() {
        //amazon sayfasına gidelim
        driver.get("");
        TakesScreenshot ts=(TakesScreenshot) driver;

    }
}
