import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
4-) Click on the "Login" button
5-) Verify that the appropriate error message is displayed.
 */
public class WO_002_LP_02TEST  extends Hooks {
    @Test
    void verifyLoginFailure(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webOrderButton = driver.findElement(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]"));
        webOrderButton.click();

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameTextBox.sendKeys("InvalidUserName");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordTextBox.sendKeys("Academy");

        WebElement webElement = driver.findElement(By.id("login-button"));
        webElement.click();

        WebElement userNameErrorMessage = driver.findElement(By.id("username-error-alert"));

        assertEquals("Invalid username",userNameErrorMessage.getText(),"User able to log in with invalid username");











    }


}
