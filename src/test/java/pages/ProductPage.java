package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final By CART_LINK = By.id("cartur");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//a[@onclick = 'addToCart(1)']");

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON)).click();
    }

    public void clickShoppingCart(){
        wait.until(ExpectedConditions.elementToBeClickable(CART_LINK)).click();
    }
}

