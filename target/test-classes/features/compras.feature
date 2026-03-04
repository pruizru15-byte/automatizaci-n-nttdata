Feature: Funcionalidad de Checkout Unico

  Scenario: Realizar la compra completa de un producto paso a paso
    Given abro la aplicacion y selecciono la "Sauce Labs Backpack"
    And agrego el producto al carro
    And voy al carro de compras
    And aumento la cantidad en uno
    When proceso los pagos e inicio el checkout
    Then hago login con usuario "DEMO" y password "DEMO"
    And completo los datos del formulario de direccion
    And completo los datos del checkout de la tarjeta
    And reviso y apruebo la orden
    And continuo comprando y salgo a la casita del celular
