package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

        //WebElement
        By emailField = By.cssSelector("input[type='email']");
        By passwordField = By.cssSelector("input[type='password']");
        By loginBtn = By.cssSelector("button[type='submit']");

        //HelperMethods

    public void provideEmail(String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        findElement(loginBtn).click();
    }
    public void loginToKoel(){
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLogin();


    }
}
