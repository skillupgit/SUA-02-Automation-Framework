import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    private static final int Seconds = 5;
    private WebDriverWait wait;

    @Test
    public void loginEmptyEmailPassword() {
        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void logicSuccess() {
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLogin();

        wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        WebElement profileAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile img")));
        Assert.assertTrue(profileAvatar.isDisplayed());
    }

    @Test(enabled = false)
    public void incorrectEmail() {
        String expectedUrl = "https://demo.koel.dev/";

        provideEmail("google@koel.dev");

        wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        providePassword("demo");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        clickLogin();

        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(enabled = false)
    public void incorrectPassword() {
        String expectedUrl = "https://demo.koel.dev/";

        provideEmail("demo@koel.dev");

        wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        providePassword("12345");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        clickLogin();

        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(enabled = true, description = "Not Yet due to issue")
    public void logOutTest() {
        String expectedUrl = "https://demo.koel.dev/";

        provideEmail("demo@koel.dev");

        wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        providePassword("demo");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        clickLogin();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile img")));
        logOut();

        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(enabled = false, dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataSets.class)
    public void negativeLoginTest(String email, String password) {
        String expectedUrl = "https://demo.koel.dev/";

        provideEmail(email);

        wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        providePassword(password);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        clickLogin();

        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
