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
5-) Select "FamilyAlbum" from Product dropdown.
6-) Enter "3" as quantity number.
7-) Enter "17" as discount percentage.
8-) Enter "Inar Academy" as Name.
9-) Enter "1100 Congress Ave" as Street.
10-) Enter "Austin" as City.
11-) Enter "TX" State.
12-) Enter "78701" as Zip Code(number).
13-) Select "Mastercard" as Card Type.
14-) Enter "5162738261027163" as Card Number.
15-) Enter "11/28" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the invalid Product Information error message is displayed.
 */

public class WO_007_OP_02TEST extends Hooks{
    @Test
    void VerifyOrderPlacementWithoutCalculation(){
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
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantitiyDropdown = driver.findElement(By.id("quantityInput"));
        quantitiyDropdown.sendKeys("3");

        WebElement discountDropdown = driver.findElement(By.id("discountInput"));
        discountDropdown.sendKeys("17");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        WebElement masterCardRadio = driver.findElement(By.id("mastercard"));
        masterCardRadio.click();

        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys("5162738261027163");

        WebElement expireDateField = driver.findElement(By.id("expiryDate"));
        expireDateField.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(), 'Process')]"));
        processButton.click();

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,-1000)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement calculateErrorMessage = driver.findElement(By.xpath("//em[contains(text(),'Fix errors in Product Information')]"));

        assertEquals("Fix errors in Product Information ",calculateErrorMessage.getText());






    }

}
