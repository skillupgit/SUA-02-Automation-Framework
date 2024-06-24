import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("demo@koel.dev");
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));

        providePassword("demo");
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));

        loginToKoel();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));


        clickPlay();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Play or resume']")));


        Assert.assertTrue(isSongPlaying(), "The song is not playing.");
    }

    public void loginToKoel() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    public void clickPlay() {
        WebElement playBtn = driver.findElement(By.xpath("//button[@title='Play or resume']"));
        playBtn.click();
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@class='song-info playing']"));
        return soundBar.isDisplayed();
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
