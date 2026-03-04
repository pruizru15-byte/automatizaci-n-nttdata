package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutAddressPage {
    private AndroidDriver driver;
    // Localizadores
    private By fullName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    private By address1 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET");
    private By address2 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET");
    private By city = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET");
    private By state = AppiumBy.id("com.saucelabs.mydemoapp.android:id/stateET");
    private By zip = AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET");
    private By country = AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET");
    private By paymentBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public CheckoutAddressPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void fillAddressAndProceed() {
        driver.findElement(fullName).sendKeys("PIERO");
        driver.findElement(address1).sendKeys("DIRECCION");
        driver.findElement(address2).sendKeys("DIRECCION 2");
        driver.findElement(city).sendKeys("CIUDAD");
        driver.findElement(state).sendKeys("REGION");
        driver.findElement(zip).sendKeys("CODIGO");
        driver.findElement(country).sendKeys("COUNTRY");
        driver.findElement(paymentBtn).click();
    }
}
