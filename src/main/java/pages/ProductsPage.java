package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {
    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        // Hacemos scroll hasta encontrar la descripcion del producto y luego hacemos click
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + productName + "\"))"));
        driver.findElement(AppiumBy.accessibilityId(productName)).click();
    }
}
