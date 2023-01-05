package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Reuseable;

public class QualitydemyPage {
    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement kullaniciEmailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement basariliGirisCoursesLinki;

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement cookies;

    public  void handleCookies(){
        if(cookies.isDisplayed()) {
            cookies.click();
            Reuseable.bekle(2);
        }
    }


}
