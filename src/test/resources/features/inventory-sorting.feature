Feature: As a customer I want to be able to sort the products

  Background:
    Given I navigated to the inventory page

  @inventory-sorting
  Scenario: As a customer I want sort products by Price(low to high)
    When I change the products to be sorted from "low to high"
    Then I should see the products sorted lowest to highest price

  @inventory-sorting
  Scenario: As a customer I want sort products by Price(high to low)
    When I change the products to be sorted from "high to low"
    Then I should see the products sorted highest to lowest price

  @inventory-sorting
  Scenario: As a customer I want sort products by alphabetical
    When I change the products to be sorted from "a to z"
    Then I should see the products sorted alphabetically

  @inventory-sorting
  Scenario: As a customer I want sort products by reverse alphabetical
    When I change the products to be sorted from "z to a"
    Then I should see the products sorted reverse alphabetically
