package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProductInCartTest extends BaseTest {

    @Test
    public void checkProductInCart() {
        homePage.open();
        homePage.clickOpenProductPageButton("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        productPage.clickShoppingCart();
        Assert.assertTrue(cartPage.checkProduct("Samsung galaxy s6"));
    }
}
