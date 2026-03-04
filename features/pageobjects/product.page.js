class ProductPage {
    get increaseQuantityBtn() {
        // En My Demo App suele ser counter plus button o un boton con +
        return $('~counter plus button');
    }

    get addToCartBtn() {
        // En My Demo App suele ser Tap to add product to cart
        return $('~Tap to add product to cart');
    }

    get cartIcon() {
        return $('~cart badge');
    }

    async increaseQuantity() {
        // Sometimes it might not exist if only 1 is added, try to click it, but handle exception or use wait
        try {
            await this.increaseQuantityBtn.waitForDisplayed({ timeout: 5000 });
            await this.increaseQuantityBtn.click();
        } catch (e) {
            console.log("No se pudo agregar mas cantidad o el boton no estaba visible. Fallback: buscar boton con text= +", e);
            const plus = await $('//*[@text="+"]');
            if (await plus.isExisting()) {
                await plus.click();
            }
        }
    }

    async addToCart() {
        await this.addToCartBtn.waitForDisplayed({ timeout: 10000 });
        await this.addToCartBtn.click();
    }

    async goToCart() {
        await this.cartIcon.waitForDisplayed({ timeout: 10000 });
        await this.cartIcon.click();
    }
}

module.exports = new ProductPage();
