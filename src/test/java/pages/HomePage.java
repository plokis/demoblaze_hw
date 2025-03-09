package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_BUTTON = By.id("login2");
    private static final By USERNAME_FIELD = By.id("loginusername");
    private static final By PASSWORD_FIELD = By.id("loginpassword");
    private static final By LOGIN_MODAL_BUTTON = By.xpath("//button[@onclick = 'logIn()']");
    private static final By WELCOME_MESSAGE = By.id("nameofuser");

    private static final String OPEN_PRODUCT_PAGE_PATTERN = "//a[text()='%s']/ancestor::h4[@class='card-title']";

    public void open() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_MODAL_BUTTON)).click();
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_MESSAGE)).getText();
    }

    public boolean checkInvisibilityOfWelcomeMessage() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(WELCOME_MESSAGE));
    }

    public void clickOpenProductPageButton(String product){
        By openProductPage = By.xpath(String.format(OPEN_PRODUCT_PAGE_PATTERN, product));
        wait.until(ExpectedConditions.elementToBeClickable(openProductPage)).click();;
    }
}
