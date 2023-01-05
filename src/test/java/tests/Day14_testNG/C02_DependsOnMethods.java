package tests.Day14_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {
    @Test(priority = -3)
    public void ilkTest(){
        System.out.println("Ilk test calisti");
        Assert.assertTrue(5>9);
    }

    @Test(dependsOnMethods = "ilkTest")
    public void ikinciTest(){
        System.out.println("Ikinci test calisti");
    }


    @Test(dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){
        System.out.println("Ucuncu test calisti");
    }
}
