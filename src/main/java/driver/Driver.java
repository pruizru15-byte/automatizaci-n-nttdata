package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setDeviceName("Galaxy A16");
                options.setAutomationName("UiAutomator2");
                options.setApp("D:\\descargas\\mda-2.0.2-23.apk");
                options.setAutoGrantPermissions(true);
                options.setAppWaitActivity("*");
                // Aumentamos el timeout para evitar errores si el APK tarda en instalarse
                options.setUiautomator2ServerInstallTimeout(Duration.ofMillis(90000));

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
