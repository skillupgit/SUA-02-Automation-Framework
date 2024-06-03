import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

        String url ="https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void logicSuccess() throws InterruptedException {

        provideEmail("demo@koel.dev");
        Thread.sleep(1000);

        providePassword("demo");
        Thread.sleep(1000);

        clickLogin();
        Thread.sleep(1000);

        WebElement profileAvatar = driver.findElement(By.cssSelector("a.view-profile img"));

        Assert.assertTrue(profileAvatar.isDisplayed());

    }

    @Test
    public void incorrectEmail() throws InterruptedException {

        provideEmail("google@koel.dev");
        Thread.sleep(1000);

        providePassword("demo");
        Thread.sleep(1000);

        clickLogin();
        Thread.sleep(1000);

        WebDriver driver = ;
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void incorrectPassword() throws InterruptedException {

        provideEmail("demo@koel.dev");
        Thread.sleep(1000);

        providePassword("12345");
        Thread.sleep(1000);

        clickLogin();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
