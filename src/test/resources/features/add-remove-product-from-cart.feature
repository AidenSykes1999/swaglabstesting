Feature: As a customer I want to have the option to add and remove products from the cart so I can choose what to buy

  Background:
    Given I am on the products page

  @add-remove-cart
  Scenario: As a customer I want to add a product from the products to the cart then review it
    Given I click to add or remove "Sauce Labs Backpack" button to the basket from the products page
    When I click the cart button on the products page
    Then I should be able to see the "Sauce Labs Backpack"
    And I should see quantity of <1> for "Sauce Labs Backpack"
    And I should see the correct price for "Sauce Labs Backpack"

  @add-remove-cart
  Scenario: As a customer I want to add a product from the products to the cart then remove it
    Given I click to add or remove "Sauce Labs Onesie" button to the basket from the products page
    When I click the cart button on the products page
    And I click remove the "Sauce Labs Onesie"
    Then I shouldn't see the "Sauce Labs Onesie" in the cart

  @add-remove-cart
  Scenario: As a customer I want to add multiple products from the products to the cart
    Given I click to add or remove "Sauce Labs Bolt T-Shirt" button to the basket from the products page
    And I click to add or remove "Sauce Labs Bike Light" button to the basket from the products page
    When I click the cart button on the products page
    Then I should be able to see the "Sauce Labs Bolt T-Shirt"
    And I should be able to see the "Sauce Labs Bike Light"
    And I should see <2> products on the cart page

  @add-remove-cart
  Scenario: As a customer I want to add a product from the product details to the cart
    Given I click the to a see "Test.allTheThings() T-Shirt (Red)" product details
    And I click the add or remove button on products details page
    When I click the cart button on the product details page
    Then I should be able to see the "Test.allTheThings() T-Shirt (Red)" 
  
  @add-remove-cart
  Scenario: As a customer I want to add a product from the product details then remove it
    Given I click the to a see "Sauce Labs Fleece Jacket" product details
    And I click the add or remove button on products details page
    And I click the add or remove button on products details page
    When I click the cart button on the product details page
    Then I shouldn't see the "Sauce Labs Fleece Jacket" in the cart

  @add-remove-cart
  Scenario: As a customer I want to be able to see the amount products in my cart on the products page updating
    When I click to add or remove "Sauce Labs Bolt T-Shirt" button to the basket from the products page
    Then I should see <1> as the cart number in the top right
    When I click to add or remove "Sauce Labs Backpack" button to the basket from the products page
    Then I should see <2> as the cart number in the top right
    When I click to add or remove "Sauce Labs Bolt T-Shirt" button to the basket from the products page
    Then I should see <1> as the cart number in the top right
