package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final By PLACE_ORDER_BUTTON = By.className("btn-success");
    private static final By NAME_FIELD = By.id("name");
    private static final By COUNTRY_FIELD = By.id("country");
    private static final By CITY_FIELD = By.id("city");
    private static final By CARD_NUMBER_FIELD = By.id("card");
    private static final By CARD_MONTH_FIELD = By.id("month");
    private static final By CARD_YEAR_FIELD = By.id("year");
    private static final By PURCHASE_BUTTON = By.xpath("//button[@onclick = 'purchaseOrder()']");
    private static final By SUCCESSFUL_ICON = By.xpath("//div[@class = 'sa-icon sa-success animate']");

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PLACE_ORDER_BUTTON)).click();
    }

    public void fillInfoPurchaseWindow(String name, String country, String city, String card_number, String card_month,
                                       String card_year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_FIELD)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COUNTRY_FIELD)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_FIELD)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_NUMBER_FIELD)).sendKeys(card_number);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_MONTH_FIELD)).sendKeys(card_month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_YEAR_FIELD)).sendKeys(card_year);
        wait.until(ExpectedConditions.elementToBeClickable(PURCHASE_BUTTON)).click();
    }

    public boolean checkSuccessfulOrderIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_ICON)).isDisplayed();
    }
}
