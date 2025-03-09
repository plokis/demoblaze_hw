package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LogInOutTest extends BaseTest {

    /*
    1. Открыть страницу https://www.demoblaze.com/
    2. Ввести в поле Username значение klopis и в поле Password значение spid_demoblaze
    3. Нажать кнопку Log in
    4. Проверить, что мы видим сообщение Welcom klopis в правом верхнем углу страницы
    */

    /*
    1. Открыть страницу https://www.demoblaze.com/
    2. Ввести в поле Username значение klopis и в поле Password значение spid_demoblaze
    3. Нажать кнопку Log in
    4. Нажать кнопку Log out
    5. Проверить, что мы не видим сообщение Welcom klopis в правом верхнем углу страницы
    */
    
    @BeforeMethod
    public void preconditionLogIn() {
        homePage.open();
        homePage.login("klopis","spid_demoblaze");
    }
    
    @Test
    public void checkLogIn() {
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome klopis");
    }

    @Test
    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2"))).click();
        Assert.assertTrue(homePage.checkInvisibilityOfWelcomeMessage());
    }

}
