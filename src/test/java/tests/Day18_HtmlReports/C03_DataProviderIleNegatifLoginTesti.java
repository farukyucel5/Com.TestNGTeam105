package tests.Day18_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.configReader;

public class C03_DataProviderIleNegatifLoginTesti {

    //Quality demi ana sayfaya gidin
    //yanlış email ve şifre ile giriş yapılamadığını test edin
    /*
      A11 A12345
      B12 B12345
      C13 C12345
      D14 D12345
      E15 E12345
    */

    @Test(dataProvider = "kullanıcıBilgileri")
    public void negatifLoginTest(String username,String password) {
        Driver.getDriver().get(configReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        qualitydemyPage.handleCookies();
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

    }

    @DataProvider
    public static Object[][] kullanıcıBilgileri() {

        Object[][] usersArr={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"}};
        return usersArr;
    }



}
