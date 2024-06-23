import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        navigateToPage();
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();
        Thread.sleep(2000);

        // Click the play button
        clickPlay();
        Thread.sleep(2000);

        // Assertion
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

}
