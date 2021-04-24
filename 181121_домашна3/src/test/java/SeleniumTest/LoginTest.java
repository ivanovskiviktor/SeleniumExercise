package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    //T1: Login with invalid credentials ( email )
    @Test
    public void InvalidCredentials() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("nepostoeckiemail@gmail.com","nepostoeckiPassword");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "The email you entered isn’t connected to an account. Find your account and log in.");

    }
    // Login with invalid credentials ( password )
    @Test
    public void InvalidCredentials1() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("vikac_zver@hotmail.com","netocenPassword");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "The password you’ve entered is incorrect. Forgot Password?");
    }

    //T2: Login with empty username ( email )
    @Test
    public void EmptyEmail() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "nekojPassword");
        String errorMessage = loginPage.getErrorMessage();

        assertEquals(errorMessage, "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");
    }

    //T3: Login successfully
    @Test
    public void successfulLogin() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("grazieromalll@outlook.com", "goheat1234q");
        // after successful login I'm not navigated to facebook.com homepage, but to facebook.com/?sk=welcome because it's a new profile made for this homework
        assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/?sk=welcome");
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
