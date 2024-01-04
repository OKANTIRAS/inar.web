import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter "Inar" as username and "Academy" password.
4-) Click on the "Login" button.
5-) Verify that the user is successfully logged in.
 */

public class WO_001_LP_01TEST extends Hooks {
    @Test
    void verifyLoginFunctionality(){
        WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webOrderButton.click();

        WebElement userNameTextBox = driver.findElement(By.id("login-username-input"));
        userNameTextBox.sendKeys("Inar");

        WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement welcomeText = driver.findElement(By.id("welcome-heading"));

        assertEquals("Welcome, Inar!",welcomeText.getText(),"Login process is not working succesfully");
    }
}
