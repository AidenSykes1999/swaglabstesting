Feature: As a customer I want to be able to sort the products

  Background:
    Given I navigated to the inventory page

  @inventory
  Scenario: As a customer I want sort products by Price(low to high)
    When If I change the products to be sorted from "low to high"
    Then I should see the products sorted lowest to highest price

#  @inventory
#  Scenario: As a customer I want sort products by Price(high to low)
#    When If I change the products to be sorted from "high to low"
#    Then I should see the products sorted highest to lowest price