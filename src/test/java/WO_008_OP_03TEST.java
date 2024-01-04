import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "MyMoney" from Product dropdown.
6-) Enter "8" as quantity number.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "92@#83" as Zip Code.
14-) Select "American Express" as Card Type.
15-) Enter "342738261027163" as Card Number.
16-) Enter "01/28" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the invalid Zip Code error message is displayed.
 */

public class WO_008_OP_03TEST extends Hooks {
    @Test
    void VerifyOrderPlacementwithInvalidZipCode() {
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

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Austin");

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("TX");

        WebElement zipField = driver.findElement(By.id("zip"));
        zipField.sendKeys("92@#83");

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 1000)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement amerikanExpressRadio = driver.findElement(By.id("amex"));
        amerikanExpressRadio.click();

        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys("342738261027163");

        WebElement expireDateField = driver.findElement(By.id("expiryDate"));
        expireDateField.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(), 'Process')]"));
        processButton.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@role='alert']"));

        assertNotEquals("New order has been successfully added.",confirmationMessage.getText(),"with invalid zip should not be accesible");


    }
}
