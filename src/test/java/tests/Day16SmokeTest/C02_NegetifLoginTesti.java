package tests.Day16SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.Reuseable;
import utilities.configReader;

public class C02_NegetifLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin

    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get(configReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(configReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(configReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.handleCookies();
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Reuseable.bekle(3);
        Driver.closeDriver();
    }

    @Test
    public void yanlisPasswordTesti(){
        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(configReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(configReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(configReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.handleCookies();
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Reuseable.bekle(3);
        Driver.closeDriver();

    }


    @Test
    public void yanlisUsernameYanlisPasswordTesti(){

        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(configReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(configReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(configReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.handleCookies();
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Reuseable.bekle(3);
        Driver.closeDriver();
    }

}
