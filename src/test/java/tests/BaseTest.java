package test.java.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.pages.BasePage;
import test.java.utils.DriverManager;
import test.java.utils.UrlConstants;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage currentPage;
    protected WebDriverWait wait;

    private final long WAIT_TIME_SEC = 1000 * 1;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_SEC));
        driver.get(UrlConstants.BASE_URL);
        WebElement cookieButton = driver.findElement(By.id("sp-cc-accept"));
        cookieButton.click();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            // driver.quit();
        }
    }
}
