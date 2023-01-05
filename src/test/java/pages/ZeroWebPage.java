package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebPage {

    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signinBtn;
    @FindBy(xpath = "//input[@id='user_login']")
    public  WebElement usernameBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public  WebElement passwordBox;

    @FindBy(xpath = "//input[@name='submit']")
    public  WebElement submit;

    @FindBy(xpath = "//strong[normalize-space()='Online Banking']")
    public  WebElement onlineBanking;
    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public  WebElement payBillLink;
    @FindBy(linkText = "Purchase Foreign Currency")
    public  WebElement purchaseCurency;
    @FindBy(id = "pc_currency")
    public WebElement currency;
}
