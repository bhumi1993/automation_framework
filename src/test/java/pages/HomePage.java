package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(id = "ap_email")
    private WebElement emailIdInput;
    @FindBy(id = "ap_password")
    private WebElement pwdInput;

    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.wait = wait;
    }

    public void Login(String username, String password) {
        ClickElementById("nav-link-accountList");

        // Enter email id
        emailIdInput.sendKeys(username);
        emailIdInput.submit();

        // Enter password
        pwdInput.sendKeys(password);
        pwdInput.submit();
    }

    public void SearchItem(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.submit();
    }

    public void AddToCart() {
        String id = "add-to-cart-button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        ClickElementById(id);
    }

    public void RemoveWarrentyPanel() {
        var warrantyPane = driver.findElement(By.id("attach-warranty-pane"));
        if (warrantyPane != null) {
            warrantyPane.findElement(By.id("attachSiNoCoverage")).click();
        }
    }

    public void WaitForElementToLoadByCss(String cls) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cls)));
    }

    public void ChangeQty(String qty) {
        WebElement quantityInput = driver.findElement(By.id("quantity"));
        // quantityInput.clear();
        quantityInput.sendKeys(qty);
        quantityInput.submit();
    }

    public void DeleteItem() {
        ClickElementByXpath(
                "/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[3]/div[1]/span[2]/span/input");
    }

    public void ProceedToCheckout() {
        ClickElementByName("proceedToRetailCheckout");
    }

    public void ApplyCouponCode(String couponCode) {
        // Apply coupon code
        WebElement couponInput = driver.findElement(By.id("spc-gcpromoinput"));
        couponInput.sendKeys(couponCode);

        WebElement applyCouponButton = driver.findElement(By.id("gcApplyButtonId"));
        applyCouponButton.click();
    }

    public void NavigateToCart() {
        ClickElementById("nav-cart");
    }

    public void WaitForResultToLoad() {
        WebElement firstSearchResult = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".s-result-item:first-child h2 a")));
        firstSearchResult.click();
    }

    public void BuyNow() {
        WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("buy-now-button")));
        buyNowButton.click();
    }

    public void RemovePrimePanel() {
        // Check if prime panel is there or not, if yes, then click "No thnaks" button
        var primePanel = driver.findElement(By.className("a-popover-wrapper")); //
        if (primePanel != null) {
            driver.findElement(By.id("primepanel_nothanks-truespc")).click();
        }
    }
}
