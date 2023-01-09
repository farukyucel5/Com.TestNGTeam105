package tests.Day18_HtmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.configReader;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
        @DataProvider istediğimiz test methoduna test datası sağlamak için kullanılır
        sadece tek bir şartı var o da iki katlı bir object array'i döndürmelidir.
         */
        Object[][] amazonKelimelerDizisi={{"Nutella"},{"Apple"},{"Samsung"}};
        return amazonKelimelerDizisi;
    }

    //amazona gidelim
    //Nutella,java,apple,samsung kelimeleriiçin arama yapın
    //sonucları test edin
    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        Driver.getDriver().get(configReader.getProperty("amazonUrl"));

        AmazonPage amazonPage=new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime, Keys.ENTER);

        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));

    }
}
