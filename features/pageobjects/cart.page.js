class CartPage {
    get myCartTitle() {
        return $('//*[@text="My Cart"]');
    }

    get checkoutBtn() {
        // Suponiendo Checkout o text = Checkout
        return $('~Proceed To Checkout button');
    }

    async validateCartHasItems() {
        // En Sauce Labs Demo suele aparecer "Proceed To Checkout button" si hay items
        const proceedBtn = await this.checkoutBtn;
        try {
            await proceedBtn.waitForDisplayed({ timeout: 10000 });
            console.log("Carrito actualizado correctamente con los productos.");
        } catch (e) {
            console.log("No se encontro Proceed To Checkout button, buscando alternativas", e);
            // Alternate validation: finding ANY item string
            const firstItemPrice = await $('//*[@content-desc="product price"]');
            await firstItemPrice.waitForDisplayed({ timeout: 5000 });
        }
    }
}

module.exports = new CartPage();
