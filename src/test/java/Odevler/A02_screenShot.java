package Odevler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;

public class A02_screenShot extends TestBase {
    TakesScreenshot ts= (TakesScreenshot) driver;
    //fotoğrafı kaydetmek için file oluştururuz
    File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa/");
    File resimGeciciDosya=ts.getScreenshotAs(OutputType.FILE);
}
