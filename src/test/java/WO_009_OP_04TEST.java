import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "SportsEquipment" from Product dropdown.
6-) Enter "1" as quantity number.
7-) Enter "10" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "78701" as Zip Code(number).
14-) Enter "4938220192845" as Card Number.
15-) Enter "09/26" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the Card Type error message is displayed.
 */

public class WO_009_OP_04TEST extends Hooks {
    @Test

    void VerifyOrderPlacementWithoutCardType(){
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
        select.selectByVisibleText("SportsEquipment");

        WebElement quantitiyDropdown = driver.findElement(By.id("quantityInput"));
        quantitiyDropdown.sendKeys("1");

        WebElement discountDropdown = driver.findElement(By.id("discountInput"));
        discountDropdown.sendKeys("10");


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
        zipField.sendKeys("78701");

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 1000)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys("4938220192845");

        WebElement expireDateField = driver.findElement(By.id("expiryDate"));
        expireDateField.sendKeys("09/26");

        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(), 'Process')]"));
        processButton.click();

        WebElement cardTypeErrorMessage = driver.findElement(By.xpath("//em[contains(text(), 'Card type cannot be empty')]"));

        assertEquals("Card type cannot be empty",cardTypeErrorMessage.getText());



    }
}
