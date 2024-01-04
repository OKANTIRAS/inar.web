import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "ScreenSaver" from Product dropdown.
6-) Leave blank the quantity box.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify the invalid Quantity error message is displayed.
 */

public class WO_005_CF_02TEST extends  Hooks {
    @Test

    void VerifyCalculateFunctionalityInOrderPageInvalidInput(){
        WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webOrderButton.click();

        WebElement userNameTextBox = driver.findElement(By.id("login-username-input"));
        userNameTextBox.sendKeys("Inar");

        WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement orderButton = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
        orderButton.click();

        WebElement productDropdown = driver.findElement(By.id("productSelect"));
        productDropdown.sendKeys("ScreenSaver");


        WebElement discountDropdown = driver.findElement(By.id("discountInput"));
        discountDropdown.sendKeys("20");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(), 'Calculate')]"));
        calculateButton.click();

        WebElement quantitiyErrorMessage = driver.findElement(By.cssSelector("#quantityValidateError"));


        assertEquals("Field 'Quantity' must be greater than zero.",quantitiyErrorMessage.getText());








    }
}
