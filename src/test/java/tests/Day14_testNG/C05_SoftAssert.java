package tests.Day14_testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssert {
    @Test(groups = {"minireg1","smoke"})
    public void test01(){

        // 1.adim softAssert objesi olusturmak

        SoftAssert softAssert= new SoftAssert();

        // 2.adim softAssert objesini kullanarak istenilen assertion'lari yapin

        softAssert.assertEquals(8,8); // Failed
        System.out.println("1.assertion sonrasi");

        softAssert.assertTrue(5>3); // Passed
        System.out.println("2.assertion sonrasi");

        softAssert.assertFalse(2>5); // Failed
        System.out.println("3.assertion sonrasi");

        // 3.adim softAssert'e raporla diyecegiz
        softAssert.assertAll(); // Bu satirda calisma durur, cunku failed olan assertion var
        System.out.println("assertAll sonrasi");
    }
}
