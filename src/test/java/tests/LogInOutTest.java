package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LogInOutTest extends BaseTest {

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
