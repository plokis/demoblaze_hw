package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkout() {
        homePage.open();
        homePage.clickOpenProductPageButton("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        productPage.clickShoppingCart();
        cartPage.clickPlaceOrderButton();
        cartPage.fillInfoPurchaseWindow("c","c","c","c","c","c");
        Assert.assertTrue(cartPage.checkSuccessfulOrderIcon());
    }
}
