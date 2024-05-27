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

//      Added ChromeOptions argument below to fix websocket error
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void logicSuccess() throws InterruptedException {

        //Pre-Conditions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Step 1

        String url = "https://demo.koel.dev/";
        driver.get(url);

        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        Thread.sleep(1000);

        // Step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        Thread.sleep(1000);

        //Step 4
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        //Assertions - Expected VS actual Results
        WebElement profileAvatar = driver.findElement(By.cssSelector("a.view-profile img"));

        Assert.assertTrue(profileAvatar.isDisplayed());


        //close Browse
        driver.quit();
    }

    @Test
    public void logicFailed() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://demo.koel.dev/";
        driver.get(url);


        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@gmail.com");
        Thread.sleep(1000);


        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        Thread.sleep(1000);


        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);


        WebElement profileAvatar = driver.findElement(By.cssSelector("a.view-profile img"));

        Assert.assertTrue(profileAvatar.isDisplayed());


        //close Browse
        driver.quit();


    }

    @Test
    public void logicFailed2() throws InterruptedException {


        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://demo.koel.dev/";
        driver.get(url);


        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        Thread.sleep(1000);


        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("12345");
        Thread.sleep(1000);


        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);


        WebElement profileAvatar = driver.findElement(By.cssSelector("a.view-profile img"));

        Assert.assertTrue(profileAvatar.isDisplayed());



        driver.quit();
    }
}
