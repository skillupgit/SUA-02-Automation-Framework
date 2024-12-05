import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTest {

    @Test(dataProvider = "ProfileNameChangeTestData", dataProviderClass = TestDataSets.class)
    public void profileNameChangeTest(String newName) {

        provideEmail("demo@koel.dev");
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));

        providePassword("demo");
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));

        clickLogin();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

        clickOnProfileAvatar();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Avatar of Koel']")));

        enterCurrentPassword("demo");
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='current_password']")));

        editName(newName);
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='inputProfileName']")));

        saveChanges();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-submit']")));

        verifySuccessMessage();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/ul/li/div/main")));
    }

    public void clickOnProfileAvatar() {
        WebElement profileIcon = driver.findElement(By.cssSelector("img[alt='Avatar of Koel']"));
        profileIcon.click();
    }

    public void editName(String newName) {
        WebElement editNameField = driver.findElement(By.cssSelector("input[id='inputProfileName']"));
        editNameField.click();
        editNameField.clear();
        editNameField.sendKeys(newName);
    }

    public void saveChanges() {
        WebElement saveChanges = driver.findElement(By.cssSelector("button[class='btn-submit']"));
        saveChanges.click();
    }

    public void enterCurrentPassword(String currentPassword) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("input[name='current_password']"));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public void verifySuccessMessage() {
        WebElement profileUpdate = driver.findElement(By.xpath("//*[@id='app']/ul/li/div/main"));
        Assert.assertTrue(profileUpdate.isDisplayed());
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
