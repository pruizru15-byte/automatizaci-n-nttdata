package steps;

import driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;

public class CartSteps {
    private AndroidDriver driver;
    
    private ProductsPage productsPage;
    private ProductDetailsPage detailsPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private CheckoutAddressPage addressPage;
    private CheckoutPaymentPage paymentPage;
    private ReviewOrderPage reviewPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        productsPage = new ProductsPage(driver);
        detailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        addressPage = new CheckoutAddressPage(driver);
        paymentPage = new CheckoutPaymentPage(driver);
        reviewPage = new ReviewOrderPage(driver);
    }

    @Given("abro la aplicacion y selecciono la {string}")
    public void seleccionoProducto(String producto) throws InterruptedException {
        Thread.sleep(3000); // Esperar que la app cargue
        productsPage.selectProduct(producto);
    }

    @Given("agrego el producto al carro")
    public void agregoAlCarro() {
        detailsPage.addToCart();
    }

    @Given("voy al carro de compras")
    public void voyAlCarro() {
        detailsPage.goToCart();
    }

    @Given("aumento la cantidad en uno")
    public void aumentoCantidad() {
        cartPage.addQuantity();
    }

    @When("proceso los pagos e inicio el checkout")
    public void procesoLosPagos() {
        cartPage.proceedToCheckout();
    }

    @Then("hago login con usuario {string} y password {string}")
    public void hagoLogin(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("completo los datos del formulario de direccion")
    public void completoDireccion() {
        addressPage.fillAddressAndProceed();
    }

    @Then("completo los datos del checkout de la tarjeta")
    public void completoCheckout() {
        paymentPage.fillPaymentAndProceed();
    }

    @Then("reviso y apruebo la orden")
    public void aprueboOrden() {
        reviewPage.placeOrder();
    }

    @Then("continuo comprando y salgo a la casita del celular")
    public void terminoYSalgo() throws InterruptedException {
        reviewPage.continueShopping();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
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
    }
}
