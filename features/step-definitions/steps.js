const { Given, When, Then } = require('@wdio/cucumber-framework');
const HomePage = require('../pageobjects/home.page');
const ProductPage = require('../pageobjects/product.page');
const CartPage = require('../pageobjects/cart.page');

Given(/^estoy en la aplicación de SauceLabs$/, async () => {
    // La aplicación se inicia sola por las capabilities de Appium
    console.log("Aplicación iniciada.");
});

Given(/^valido que carguen correctamente los productos en la galeria$/, async () => {
    await HomePage.validateProductsLoaded();
});

When(/^agrego (\d+) del siguiente producto "([^"]*)"$/, async (unidades, producto) => {
    await HomePage.selectProduct(producto);

    // Add quantity
    let additionalClicks = parseInt(unidades) - 1;
    for (let i = 0; i < additionalClicks; i++) {
        await ProductPage.increaseQuantity();
    }

    await ProductPage.addToCart();
});

Then(/^valido el carrito de compra actualice correctamente$/, async () => {
    await ProductPage.goToCart();
    await CartPage.validateCartHasItems();
});
