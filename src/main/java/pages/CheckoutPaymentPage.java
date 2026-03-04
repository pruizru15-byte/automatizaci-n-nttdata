package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutPaymentPage {
    private AndroidDriver driver;
    // Localizadores
    private By name = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By cardNumber = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    private By expDate = AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    private By securityCode = AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
    private By reviewOrderBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public CheckoutPaymentPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void fillPaymentAndProceed() {
        driver.findElement(name).sendKeys("PIERO");
        driver.findElement(cardNumber).sendKeys("325812657568789");
        driver.findElement(expDate).sendKeys("12/26");
        driver.findElement(securityCode).sendKeys("123");
        driver.findElement(reviewOrderBtn).click();
    }
}
