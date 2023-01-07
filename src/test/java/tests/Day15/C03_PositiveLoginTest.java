package tests.Day15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.Reuseable;

public class C03_PositiveLoginTest {
    @Test(groups = "smoke")
    public void test01(){

        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // 2- login linkine basin
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // 3- Kullanici email'i olarak valid email girin
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        // 4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordKutusu.sendKeys("31488081");
        // 5- Login butonuna basarak login olun
        if(qualitydemyPage.cookies.isDisplayed()) {
            qualitydemyPage.cookies.click();
            Reuseable.bekle(2);
        }
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();
    }
}
