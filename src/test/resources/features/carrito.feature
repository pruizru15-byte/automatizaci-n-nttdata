Feature: Validar funcionalidad del carrito de compras

  Scenario: Validar carrito de compra con diferentes productos en un solo pase
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego 1 del siguiente producto "Sauce Labs Backpack"
    And agrego 1 del siguiente producto "Sauce Labs Bolt - T-Shirt"
    And agrego 2 del siguiente producto "Sauce Labs Bike Light"
    Then valido el carrito de compra actualice correctamente
