package Odevler;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcell {
    @Test
    public void name() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("sayfa1").getRow(0).createCell(4).setCellValue("Nüfus");
        workbook.getSheet("sayfa1").getRow(1).createCell(4).setCellValue("150000000");
        workbook.getSheet("sayfa1").getRow(9).createCell(4).setCellValue("150000000");
        //Dosyayı kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //Dosyayı Kapatalım
        fis.close();
        fos.close();
        workbook.close();


    }
}
