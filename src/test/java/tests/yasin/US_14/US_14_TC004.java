package tests.yasin.US_14;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YasinPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_14_TC004 {

    //Belirtilen URL' e gidilir
    //Sign In butonuna tiklanir
    //Kullanici bilgileri girilir
    //My Account a tiklanir
    //Store Manager a tiklanir
    //Coupons basligina tiklanir
    //Add New butonuna  tiklanir
    //Code kutusuna miktar yazilir
    //Minimum spend kutusuna miktar girilir
    //Maximum spend kutusuna miktar girilir
    //Individual use only secenegi oldugu görülür
    //Exclude sale items secenegi tiklanabildigi test edilir


    @Test
    public void uS_14_TC004() throws InterruptedException {

        YasinPage yasinPage=new YasinPage();
        JavascriptExecutor executor=(JavascriptExecutor) Driver.getDriver();

        // Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Sign In butonuna tiklanir
        yasinPage.ilkSayfaSignInButonu.click();

        yasinPage.signInUserNameBox.sendKeys("team22.12.10.2022@gmail.com");
        yasinPage.signInPasswordBox.sendKeys("*Team2215381571?");
        yasinPage.signInButonu.click();

        Assert.assertTrue(yasinPage.signOutButonu.isDisplayed());

        //My Account a tiklanir
        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.myAccountButonu);
        executor.executeScript("arguments[0].click();",yasinPage.myAccountButonu);

        Assert.assertTrue(yasinPage.storeManagerButonu.isDisplayed());

        // Store Manager a tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.storeManagerButonu);

        //Coupons basligina tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.couponsButonu);

        //Add New butonuna  tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.addNewButonu);

        //Code kutusuna miktar yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        //Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        //Maximum spend kutusuna miktar girilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());

        //Individual use only secenegi isaretlenir
        Assert.assertTrue(yasinPage.individualUseOnlyBox.isEnabled());
        //yasinPage.individualUseOnlyBox.click();
        executor.executeScript("arguments[0].click();",yasinPage.individualUseOnlyBox);

        //Exclude sale items secenegi tiklanabildigi test edilir
        Assert.assertTrue(yasinPage.excludeSaleItemsBox.isEnabled());
        executor.executeScript("arguments[0].click();",yasinPage.excludeSaleItemsBox);















    }

}
