package tests.Day16SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.Reuseable;
import utilities.configReader;

public class C01_PositiveLoginTest {

    @Test
    public void positiveLogin(){
        //quality demi ana sayfaya git

        Driver.getDriver().get(configReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(configReader.getProperty("qdGecerliUsername"));

        qualitydemyPage.passwordKutusu.sendKeys(configReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.handleCookies();

        qualitydemyPage.loginButonu.click();

        Reuseable.bekle(2);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Reuseable.bekle(3);
        Driver.closeDriver();
    }
}
