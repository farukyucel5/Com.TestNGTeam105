package tests.Day18_HtmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseRapor;
import utilities.configReader;

public class C01_htmlReports extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Nutella testi","kullanıcı nutella arayabilmeli");
        Driver.getDriver().get(configReader.getProperty("amazonUrl"));
        extentTest.info("Amazon ana sayfaya gidildi");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella", Keys.ENTER);
        extentTest.info("arama yapıldı");
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("arama sonucları kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("arama sonucları test edildi");

    }
}
