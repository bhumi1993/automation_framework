package test.java.tests;

import org.testng.annotations.Test;

import test.java.pages.HomePage;
import test.java.utils.Utility;

public class HomePageTest extends BaseTest {

    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    @Test
    public void SearchItemAndAddToCart() {
        currentPage = new HomePage(driver, wait);

        // search for the item
        ((HomePage) currentPage).SearchItem("iphone 14 pro");

        // Wait for load screen
        ((HomePage) currentPage).WaitForElementToLoadByCss(".s-result-item");

        // Click first item
        currentPage.ClickElementByXpath(
            "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");

        Utility.Halt(Utility.WAIT_TIME_SEC);

        currentPage.ScrollDown();

        ((HomePage) currentPage).AddToCart();
        ((HomePage) currentPage).RemoveWarrentyPanel();

        assert (true);
        // Add assertions or further interactions here
    }

    @Test
    public void AddToCartWithMultipleQty() {
        currentPage = new HomePage(driver, wait);
        ((HomePage) currentPage).SearchItem("jabra");
        ((HomePage) currentPage).WaitForElementToLoadByCss(".s-result-item");
        currentPage.ClickElementByXpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");
        Utility.Halt(Utility.WAIT_TIME_SEC);
        currentPage.ScrollDown();
        ((HomePage) currentPage).ChangeQty("2");
        ((HomePage) currentPage).AddToCart();

        assert (true);
    }

    @Test(description = "Visit cart and remove the first item..")
    public void ViewCartAndDeleteItem() 
    {
        currentPage = new HomePage(driver, wait);
        ((HomePage) currentPage).Login(USERNAME, PASSWORD);

        // Click on cart button
        currentPage.ClickElementById("nav-cart");

        ((HomePage) currentPage).DeleteItem();

        assert(true);
    }

    @Test(description = "Proceed to checkout..")
    public void CheckoutYourOrder() {
        currentPage = new HomePage(driver, wait);
        ((HomePage) currentPage).Login(USERNAME, PASSWORD);
        ((HomePage) currentPage).SearchItem("iphone 14");
        ((HomePage) currentPage).WaitForElementToLoadByCss(".s-result-item");
        currentPage.ClickElementByXpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span");
        ((HomePage) currentPage).BuyNow();
        Utility.Halt(Utility.WAIT_TIME_SEC);
        ((HomePage) currentPage).RemovePrimePanel();
        Utility.Halt(6000);
        ((HomePage) currentPage).ApplyCouponCode("DEA23-ASDFX-234DJ");

        assert(true);
    }
}
