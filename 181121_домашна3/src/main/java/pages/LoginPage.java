package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.facebook.com/login/");
    }

        public boolean isLoaded() throws InterruptedException {
            Thread.sleep(5000);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).isDisplayed();

        }

        public void login(String user, String password) throws InterruptedException {
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(user);
            Thread.sleep(500);
            driver.findElement(By.id("pass")).sendKeys(password);
            Thread.sleep(500);
            driver.findElement(By.id("loginbutton")).click();
            Thread.sleep(500);


        }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.className("_9ay7"));
        return errorPage.getText();
    }
}

