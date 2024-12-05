import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }

    @Test
    public void logicSuccess() throws InterruptedException {

        //navigateToPage();

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


        //navigateToPage();

        provideEmail("google@koel.dev");
        Thread.sleep(1000);

        providePassword("demo");
        Thread.sleep(1000);

        clickLogin();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void incorrectPassword() throws InterruptedException {


        //navigateToPage();


        provideEmail("demo@koel.dev");
        Thread.sleep(1000);


        providePassword("12345");
        Thread.sleep(1000);


        clickLogin();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), url);


    }


    @Test(enabled = true, description = "Not Yet due to issue")
    public void logOutTest() throws InterruptedException {

        //navigateToPage();

        provideEmail("demo@koel.dev");
        Thread.sleep(1000);

        providePassword("demo");
        Thread.sleep(1000);

        clickLogin();
        Thread.sleep(1000);

        logOut();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }

}
