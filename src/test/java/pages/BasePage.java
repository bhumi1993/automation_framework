package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement ClickElementById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();

        return element;
    }

    public WebElement ClickElementByCss(String css) {
        WebElement element = driver.findElement(By.cssSelector(css));
        element.click();

        return element;
    }

    public WebElement ClickElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

        return element;
    }

    public WebElement ClickElementByName(String name) {
        WebElement element = driver.findElement(By.name(name));
        element.click();

        return element;
    }

    public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
    }
}