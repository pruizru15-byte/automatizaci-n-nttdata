package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {
    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        String searchName = productName.replace(" - ", " "); // "Sauce Labs Bolt T-Shirt"

        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\""
                            + searchName + "\"))"));
        } catch (Exception e) {
            // Puede que ya esté visible y no necesite scroll
        }

        // Hacemos click en la imagen específica del producto
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '" + searchName + "')]"))
                .click();
    }
}
