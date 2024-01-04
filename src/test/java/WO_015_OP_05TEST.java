import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_015_OP_05TEST extends Hooks {
    @Test
    void VerifyOrderPlacementWithoutCity(){
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
        Select select = new Select(productDropdown);
        select.selectByVisibleText("MyMoney");

        WebElement quantitiyDropdown = driver.findElement(By.id("quantityInput"));
        quantitiyDropdown.sendKeys("8");

        WebElement discountDropdown = driver.findElement(By.id("discountInput"));
        discountDropdown.sendKeys("20");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(), 'Calculate')]"));
        calculateButton.click();

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Inar Academy");

        WebElement streetField = driver.findElement(By.id("street"));
        streetField.sendKeys("1100 Congress Ave");

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("TX");

        WebElement zipField = driver.findElement(By.id("zip"));
        zipField.sendKeys("78701");

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 1000)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement visaRadio = driver.findElement(By.id("visa"));
        visaRadio.click();

        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys("4938281746192845");

        WebElement expireDateField = driver.findElement(By.id("expiryDate"));
        expireDateField.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(), 'Process')]"));
        processButton.click();

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement cityErrorMessage = driver.findElement(By.xpath("//em[contains(text(),'City cannot be empty')]"));

        assertEquals("City cannot be empty",cityErrorMessage.getText());







    }
}
