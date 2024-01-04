import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Click "Logout" button.
5-) Verify logout successfully
 */
public class WO_003_LP_03TEST extends Hooks {
    @Test
    void VerifyLogoutFunctionality(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webOrderButton = driver.findElement(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]"));
        webOrderButton.click();

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameTextBox.sendKeys("Inar");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordTextBox.sendKeys("Academy");

        WebElement webElement = driver.findElement(By.id("login-button"));
        webElement.click();

        WebElement logOut = driver.findElement(By.xpath("//button[@class='text-fifth fs-4 fw-bold text-decoration-none border-none btn-primary btn me-lg-4']"));
        logOut.click();

     try{
         WebElement text = driver.findElement(By.cssSelector("h1[class='display-1  text-fifth']"));
         System.out.println("Login process is successful! We are now at the Home Page!");
     } catch (NoSuchElementException e){
         throw new NoSuchElementException("Login process is not successful!");
     }






    }




}
