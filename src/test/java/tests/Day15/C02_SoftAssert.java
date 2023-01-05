package tests.Day15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.Driver;
import utilities.Reuseable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C02_SoftAssert {
    @Test
    public void test01(){
        ZeroWebPage zeroWebPage=new ZeroWebPage();
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        zeroWebPage.signinBtn.click();

        //3. Login kutusuna “username” yazin
        zeroWebPage.usernameBox.sendKeys("username");
       // 4. Password kutusuna “password” yazin
        zeroWebPage.passwordBox.sendKeys("password");
       // 5. Sign in tusuna basin
        zeroWebPage.submit.click();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroWebPage.onlineBanking.click();
        zeroWebPage.payBillLink.click();
        //7. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.purchaseCurency.click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroWebPage.currency);
        select.selectByValue("EUR");
       // 9. soft assert kullanarak “Eurozone (euro)” secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String sonucText="Eurozone (euro)";
        String actualText=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualText,sonucText);
        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // “Select One”,
        // “Australia (dollar)“, “Canada (dollar)“,”Switzerland (franc)“,”China (yuan)“,”Denmark (krone)“,
        // ”Eurozone (euro)“,”Great Britain (pound)“,”Hong Kong (dollar)“,”Japan (yen)“,”Mexico (peso)“,”Norway (krone)“,
        // ”New Zealand (dollar)“,”Sweden (krona)“,”Singapore (dollar)“,”Thailand (baht)”


        List<String> expectedOptionsListesi = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)");
        List<String> actualoptions=new ArrayList<>();

        List<WebElement> optionsElementList=select.getOptions();

        actualoptions=optionsElementList.stream().map(WebElement::getText).collect(Collectors.toList());

        softAssert.assertEquals(actualoptions,expectedOptionsListesi);




        softAssert.assertAll();
        Reuseable.bekle(4);

        Driver.closeDriver();
    }
}
