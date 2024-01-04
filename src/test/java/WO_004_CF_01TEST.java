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
5-) Select "HomeDecor" from Product dropdown.
6-) Enter "5" as quantity number.
7-) Enter "15" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify that the total amount is successfully displayed.
 */

public class WO_004_CF_01TEST extends Hooks {
    @Test

    void verifyCalculateFunctionalityInOrderPage(){

        WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        select.selectByVisibleText("HomeDecor");

        WebElement quantitiyDropdown = driver.findElement(By.id("quantityInput"));
        quantitiyDropdown.sendKeys("5");

        WebElement discountDropdown = driver.findElement(By.id("discountInput"));
        discountDropdown.sendKeys("15");


       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(), 'Calculate')]"));
        calculateButton.click();

        WebElement totalButton = driver.findElement(By.cssSelector("#totalInput"));

        double actualResult = Double.parseDouble(totalButton.getAttribute("value"));
        double expectedResult = Math.round(((150 - (150 * 0.15)) * 5));

        System.out.println("Testing Calculate Functionality in Order Page: \n" + "Product(input)  : 'HomeDecor' \n"
                + "Quantity(input) : '5'\n" + "Unit Price      : '150'\n" + "Discount(input) : '15'\n"
                + "Expected Result : " + expectedResult + "\nActual Result   : " + actualResult);
        assertEquals(actualResult, expectedResult, "The message displayed but result is not true!");





    }
}
