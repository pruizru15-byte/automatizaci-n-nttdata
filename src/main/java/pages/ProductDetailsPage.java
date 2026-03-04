package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductDetailsPage {
    private AndroidDriver driver;
    // Localizadores
    private By addToCartBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private By goToCartIcon = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    public ProductDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(goToCartIcon).click();
    }
}
