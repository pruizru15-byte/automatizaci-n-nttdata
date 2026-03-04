class HomePage {
    get pageTitle() {
        return $('//*[@text="Products"]');
    }

    async validateProductsLoaded() {
        await this.pageTitle.waitForDisplayed({ timeout: 15000 });
    }

    async selectProduct(productName) {
        // En Android My Demo App el texto del producto aparece en la tarjeta
        const product = await $(`//*[@text="${productName}"]`);
        await product.waitForDisplayed({ timeout: 10000 });
        await product.click();
    }

    async goToCart() {
        const cartIcon = await $('~cart badge'); // content-desc contains cart badge usually
        await cartIcon.waitForDisplayed({ timeout: 10000 });
        await cartIcon.click();
    }
}

module.exports = new HomePage();
