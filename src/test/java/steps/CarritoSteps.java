package steps;

import driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import java.time.Duration;

public class CarritoSteps {
    private AndroidDriver driver;
    private ProductsPage productsPage;
    private ProductDetailsPage detailsPage;
    private CartPage cartPage;

    public CarritoSteps() {
        driver = Driver.getDriver();
        productsPage = new ProductsPage(driver);
        detailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicacion_de_sauce_labs() {
        // La app se inicializa mediante el Driver Singleton
        // 2 puntos: Validar carga de aplicación
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean loaded = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV"))).isDisplayed();

        Assert.assertTrue(loaded, "La aplicación no cargó correctamente");
    }

    @Given("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        // 4 puntos: Uso de esperas implícitas o explícitas (esperar explícitamente a un
        // producto)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Sauce Labs Backpack\")")));
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(Integer unidades, String producto) {
        // Seleccionmos el producto desde la galería
        productsPage.selectProduct(producto);

        // 4 puntos: Agregar Producto (Esperando explicitamente al boton de carro)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Tap to add product to cart")));

        // Si se nos pide más unidades, aumentamos antes de agregarlo al carrito
        for (int i = 1; i < unidades; i++) {
            try {
                driver.findElement(AppiumBy.accessibilityId("Increase item quantity")).click();
            } catch (Exception e) {
                // Alternativa con ID
                driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV")).click();
            }
        }

        // Agregar al carrito el producto seleccionado con su cantidad
        detailsPage.addToCart();

        // Volver a la grilla de productos simulando el botón físico 'Atrás'
        driver.navigate().back();
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {
        // Navegar al carrito
        detailsPage.goToCart();

        // 4 puntos: Validar Agregar Producto
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Esperamos que el Checkout Botón esté visible confirmando que hay productos en
        // el carrito
        boolean isCartUpdated = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Confirms products for checkout"))).isDisplayed();

        Assert.assertTrue(isCartUpdated, "El carrito de compra no se encuentra actualizado.");
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (driver != null) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla: " + scenario.getName());
        }
    }

    @After
    public void teardown() {
        Driver.quitDriver();
        driver = null;
    }
}
