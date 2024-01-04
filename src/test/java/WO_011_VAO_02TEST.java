import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "6" times.
6-) Click "Check All" button.
7-) Verify all orders selected.
8-) Click "Uncheck All" button.
9-) Verify all orders are unselected.
 */

public class WO_011_VAO_02TEST extends Hooks {
    @Test
    void VerifyUncheckAllFunctionalityInViewAllOrderPage(){
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

        for(int i = 0; i <= 5; i++){
            addMoreData.click();
        }

        WebElement checkAllButton = driver.findElement(By.cssSelector("button[class='btn btn-success fs-4 text-fifth me-3']"));
        checkAllButton.click();

        List<WebElement> firstColumnElements = driver.findElements(By.cssSelector("input[type='checkbox']"));

        boolean testPassCondition = true;

        for(int i = 0; i < firstColumnElements.size(); i++){

            if(!firstColumnElements.get(i).isSelected()){

                testPassCondition = false;
                break;
            }
        }

        assertTrue(testPassCondition,"Check All BUtton Does Not Function Properly");
        WebElement uncheckAllButton = driver.findElement(By.cssSelector("button[class='btn btn-primary fs-4 text-fifth']"));
        for (int i = 0; i < 6; i++) {
            uncheckAllButton.click();
        }
        List<WebElement>uncheckFirstColumn = driver.findElements(By.className("form-check-input"));

        boolean uncheckCondition= true;

        for(int i = 0; i < uncheckFirstColumn.size(); i++){
            if(uncheckFirstColumn.get(i).isSelected()){
                uncheckCondition = false;
                break;
            }
        }
        assertTrue(uncheckCondition,"Uncheck Button Does Not Function Properly");






    }
}
