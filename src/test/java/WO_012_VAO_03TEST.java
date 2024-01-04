import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "8" times.
6-) Click 1st, 3rd and 5th orders checkbox's.
7-) Click "Delete All" button.
8-) Verify the orders are deleted.
 */

public class WO_012_VAO_03TEST extends Hooks {
    @Test
    void VerifyDeleteFunctionalityInViewAllOrderPage(){
        WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webOrderButton.click();

        WebElement userNameTextBox = driver.findElement(By.id("login-username-input"));
        userNameTextBox.sendKeys("Inar");

        WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement viewAllOrderButton = driver.findElement(By.xpath("//a[@class='text-fifth active nav-link']"));
        viewAllOrderButton.click();

        WebElement addMoreData = driver.findElement(By.cssSelector("button[class='fs-4 btn btn-primary text-fifth me-3']"));

        for(int i = 0; i < 8; i++){
            addMoreData.click();
        }
        List<WebElement>orders = driver.findElements(By.xpath("//input[@class='form-check-input']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement firstCheckBoxElement = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/input[1]"));
        WebElement thirdCheckBoxElement = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/div[1]/input[1]"));
        WebElement fifthCheckBoxElement = driver.findElement(By.xpath("//tbody/tr[5]/td[1]/div[1]/input[1]"));

        firstCheckBoxElement.click();
        thirdCheckBoxElement.click();
        fifthCheckBoxElement.click();

        String firstRowElement = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
        String thirdRowElement = driver.findElement(By.xpath("//tbody/tr[3]")).getText();
        String fifthRowElement = driver.findElement(By.xpath("//tbody/tr[5]")).getText();


        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='btn btn-danger fs-4 text-white ']"));
        deleteButton.click();

        List<WebElement> rowsInTheTable = driver.findElements(By.xpath("//tbody/tr"));

        boolean testPassCondition = true;

        for (int i = 0; i < rowsInTheTable.size(); i++) {
            if (rowsInTheTable.get(i).getText().equals(firstRowElement)) {
                testPassCondition = false;
                break;
            }
            if (rowsInTheTable.get(i).getText().equals(thirdRowElement)) {
                testPassCondition = false;
                break;
            }
            if (rowsInTheTable.get(i).getText().equals(fifthRowElement)) {
                testPassCondition = false;
                break;
            }

        }
        assertTrue(testPassCondition, "Specified orders are not deleted as expected");



    }
}
