package tests.Day19_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;
import utilities.configReader;

public class C0_AmazonSearch extends TestBaseCross {
    @Test
    public void test01(){
        driver.get(configReader.getProperty("amazonUrl"));
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        WebElement sonucYazi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucText=sonucYazi.getText();
        String expectedText="Nutella";

        Assert.assertTrue(actualSonucText.contains(expectedText));

    }
}
