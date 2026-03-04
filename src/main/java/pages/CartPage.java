package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage {
    private AndroidDriver driver;
    // Localizadores basados en sus instrucciones
    private By plusButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private By checkoutBtn = AppiumBy.accessibilityId("Confirms products for checkout");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void addQuantity() {
        driver.findElement(plusButton).click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
