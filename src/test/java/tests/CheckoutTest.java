package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    
    /*
    1. Открыть страницу магазина
    2. Нажать кнопку товара Samsung galaxy s6
    3. Нажать кнопку add to cart на странице товара
    4. Нажать кнопку Ok в Alert окне
    5. Нажать кнопку Cart
    6. Ввести кнопку Place Order
    7. Ввести данные покупателя и нажать кнопку Continue
    8. Проверить есть ли иконка с зеленой галочкой
     */
    
    @Test
    public void checkout() {
        homePage.open();
        homePage.clickOpenProductPageButton("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        productPage.clickShoppingCart();
        cartPage.clickPlaceOrderButton();
        cartPage.fillInfoPurchaseWindow("Ivan Ivanov","Russia","Moscow","456","09","26");
        Assert.assertTrue(cartPage.checkSuccessfulOrderIcon());
    }
}
