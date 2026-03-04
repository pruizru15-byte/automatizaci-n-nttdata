package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ReviewOrderPage {
    private AndroidDriver driver;
    // Localizadores
    private By placeOrderBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    private By continueShoppingBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/shoopingBt");

    public ReviewOrderPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public void continueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }
}
