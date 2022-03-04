Feature: As an observant Buyer I want to see the correct information about the products I have purchased

  Scenario: I have brought some Items
    Given I have brought the Backpack
    And I have brought the Bike Light
    And I have navigated to the Checkout Step Two Page
    Then I should have an item total of thirty nine ninety eight
