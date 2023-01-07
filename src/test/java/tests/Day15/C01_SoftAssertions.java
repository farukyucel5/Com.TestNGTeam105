package tests.Day15;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.Reuseable;

public class C01_SoftAssertions {
    @Test(groups = "minireg2")
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com/");

        SoftAssert softAssert=new SoftAssert();

        String expextedUrlWord="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expextedUrlWord));

        //nutella arat

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //arama sonucunun nutella içerdiğini test et

        String aramaSonuc=amazonPage.aramaSonucuElementi.getText();

        softAssert.assertTrue(aramaSonuc.contains("Nutella"),"Nutella icermiyor");
        Reuseable.bekle(10);

        //Java arat

        amazonPage.amazonAramaKutusu.clear();

        amazonPage.amazonAramaKutusu.sendKeys("Java",Keys.ENTER);
        String aramaSonucJava=amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucJava.contains("Java"),"Java icermiyor");

        String[] sonucArr=aramaSonucJava.split(" ");

        String sayi=sonucArr[3].replaceAll("\\W","");

        int sayi1=Integer.parseInt(sayi);

        softAssert.assertTrue(sayi1>1000,"1000 den fazla java icerigi yok");










        softAssert.assertAll();
        Driver.closeDriver();
    }
}
