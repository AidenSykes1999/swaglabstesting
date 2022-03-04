Feature: As a customer I want to have the option to add and remove products from the basket so I can choose what to buy

  Background:
    Given I am on the inventory page

  @add-remove-cart
  Scenario: As a customer I want to add a product to the cart then review it
    Given I add a "Sauce Labs Backpack" to the basket
    When I click the cart button
    Then I should be able to see "Sauce Labs Backpack"
    And A quantity of <1>
