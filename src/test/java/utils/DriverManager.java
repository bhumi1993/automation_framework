package test.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\unnat.pandya\\Projects\\Vox\\automate_vox\\VOX\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
