package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AndroidDriver driver;
    // Localizadores
    private By usernameInput = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By passwordInput = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By loginBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
